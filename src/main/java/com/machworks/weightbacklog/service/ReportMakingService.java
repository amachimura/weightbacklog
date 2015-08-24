package com.machworks.weightbacklog.service;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.machworks.weightbacklog.dto.GoalDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.machworks.weightbacklog.dao.DailyRepository;
import com.machworks.weightbacklog.dao.GoalRepository;
import com.machworks.weightbacklog.dao.SprintRepository;
import com.machworks.weightbacklog.dto.DailyWeightDto;
import com.machworks.weightbacklog.entity.DailyWeight;
import com.machworks.weightbacklog.entity.GoalEntity;
import com.machworks.weightbacklog.entity.Sprint;
import com.machworks.weightbacklog.entity.User;

import static java.util.stream.Collectors.toList;

@Component
public class ReportMakingService implements ReportMakingServiceSpec {
	@Autowired
	DailyRepository dailyRepo;
	@Autowired
	private SprintRepository sprintRepo;
	@Autowired
	private GoalRepository goalRepo;

	//for mock
	@Autowired
	private MasterDataServiceSpec masterDataService;

	@Override
	public String saveAndReport(DailyWeightDto data) {
		saveDailyWeight(data);
		String report = generateReport(data);
		return report;
	}
    @Override
	public String generateReport(DailyWeightDto data) {
    	Sprint currentSprint = sprintRepo.findOne(data.getSprint_id());
		GoalEntity currentGoal = goalRepo.findOne(currentSprint.getGoal_id());
		
		DailyReport weight = new DailyReport(currentGoal.getSlogan(), data.getToday_date(),
				data.getWeight(), currentSprint.getGoal_date(),
				currentSprint.getGoal_weight());
		

		String report = weight.writeReport();
		return report;
	}



	@Data
	@AllArgsConstructor
	static class DailyReport{
		private String projectSlogan;
		private ZonedDateTime todayDate;
		private Float todayWeight;
		private ZonedDateTime goalDate;
		private Float goalWeight;

		public String writeReport(){
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/DD");
			StringBuilder report = new StringBuilder();
			report.append(String.format("【%s】日時報告 %s", projectSlogan, format.format(todayDate))).append("\n");
			report.append("\n");
			report.append(String.format("今日の体重：　%skg",todayWeight)).append("\n");
			report.append("\n");
			report.append(String.format("短期目標: %sまでに%skg", goalDate, goalWeight)).append("\n");
			int remainDate = todayDate.compareTo(goalDate);
			float remainWeight = todayWeight - goalWeight;
			report.append(String.format("残り: %s日で%skg", remainDate, remainWeight));
			return report.toString();
		}
	}


	private void saveDailyWeight(DailyWeightDto data) {
		DailyWeight entity = new DailyWeight();
		entity.setSprint_id(data.getSprint_id());
		entity.setUser_id(data.getUser_id());
		entity.setToday_date(data.getToday_date());
		entity.setWeight(data.getWeight());
		dailyRepo.save(entity);
	}

	public String generateAkirasReport(DailyWeightDto data){
		GoalEntity goal = makeAkirasGoal();
		akirasSprints = masterDataService.generateSprints(goal);
		ZonedDateTime currentDate = ZonedDateTime.now();
		Map<ZonedDateTime, Sprint> sprintMap = new HashMap<>();
		Sprint currentSprint = akirasSprints.stream().filter(s -> s.getStart_date().isBefore(currentDate) && s.getGoal_date().isAfter(currentDate)).limit(1).collect(Collectors.<Sprint>toList()).get(0);

        DailyReport weight = new DailyReport(goal.getSlogan(), data.getToday_date(),
                data.getWeight(), currentSprint.getGoal_date(),
                currentSprint.getGoal_weight());


        String report = weight.writeReport();
        System.out.println(report);
        return report;

	}

	private List<Sprint> akirasSprints;
	private GoalEntity makeAkirasGoal(){
		GoalEntity goal = new GoalEntity();
		goal.setId(Long.valueOf(0));
		goal.setUser_id(Long.valueOf(0000));
		goal.setSlogan("10/17に80.4kg!");
		goal.setStart_weight((float) 90.4);
		goal.setStart_date(ZonedDateTime.of(2015, 06, 04, 18, 0, 0, 0, ZoneId.systemDefault()));
		goal.setGoal_weight((float) 80.4);
		goal.setGoal_date(ZonedDateTime.of(2015, 10, 17, 14, 0, 0, 0, ZoneId.systemDefault()));
		goal.setSprintSpan(7);
		return goal;
	}
}
