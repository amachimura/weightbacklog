package com.machworks.weightbacklog.service;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

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

@Component
public class ReportMakingService implements ReportMakingServiceSpec {
	@Autowired
	DailyRepository dailyRepo;
	@Autowired
	private SprintRepository sprintRepo;
	@Autowired
	private GoalRepository goalRepo;

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

}