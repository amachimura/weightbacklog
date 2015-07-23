package com.machworks.weightbacklog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.machworks.weightbacklog.controller.viewentity.DailyWeightViewEntity;
import com.machworks.weightbacklog.controller.viewentity.GoalViewEntity;
import com.machworks.weightbacklog.dto.DailyWeightDto;
import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.service.MasterDataServiceSpec;
import com.machworks.weightbacklog.service.ReportMakingServiceSpec;

@Controller
public class BacklogController {
	
	@Autowired
	private MasterDataServiceSpec master;
	@Autowired
	private ReportMakingServiceSpec report;
	
	@RequestMapping("/goal")
	@ResponseBody
	public Boolean registerGoal(@RequestBody GoalViewEntity entity){
		GoalDto dto = new GoalDto();
		dto.setUser_id(entity.getUserId());
		dto.setSlogan(entity.getSlogan());
		dto.setStart_weight(entity.getStartWeight());
		dto.setStart_date(entity.getStartDate());
		dto.setGoal_weight(entity.getGoalWeight());
		dto.setGoal_date(entity.getGoalDate());
		dto.setSprintSpan(entity.getSprintSpan());
		return master.createGoalAndSprints(dto);
	}


	@RequestMapping("/report")
	@ResponseBody
	/**
	 * save the dailyreport
	 */
	public Map<String,Object> dailyReport(@RequestBody DailyWeightViewEntity entity){
		DailyWeightDto dto = new DailyWeightDto();
		dto.setUser_id(entity.getUserId());
		dto.setWeight(entity.getWeight());
		dto.setToday_date(entity.getTodayDate());
		dto.setToFacebook(entity.isToFacebook());
		dto.setSprint_id(entity.getSprintId());
		Map<String, Object> retmap = new HashMap<>();
		retmap.put("report", report.saveAndReport(dto));
		return retmap;
	}
	
}
