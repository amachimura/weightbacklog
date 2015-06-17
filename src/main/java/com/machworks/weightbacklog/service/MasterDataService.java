package com.machworks.weightbacklog.service;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.machworks.weightbacklog.dao.GoalRepository;
import com.machworks.weightbacklog.dao.SprintRepository;
import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.entity.Sprint;

@Component
public class MasterDataService {
	@Autowired
	private SprintRepository sprintRepo;
	@Autowired
	private GoalRepository goalRepo;
	
	public Boolean updateMaster(){
		return null;
	}
	
	private List<Sprint> generateSprints(GoalDto goal) {
		ZonedDateTime dateCounter = goal.getStart_date();
		while(dateCounter.isBefore(goal.getGoal_date())){
			
		}
		return null;
	}
	private Boolean registerGoal(GoalDto goal){
		
		return true;
	}

}
