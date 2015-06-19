package com.machworks.weightbacklog.service;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.machworks.weightbacklog.dao.GoalRepository;
import com.machworks.weightbacklog.dao.SprintRepository;
import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.entity.GoalEntity;
import com.machworks.weightbacklog.entity.Sprint;
import com.machworks.weightbacklog.entity.User;

@Component
public class MasterDataService implements MasterDataServiceSpec {
	@Autowired
	private SprintRepository sprintRepo;
	@Autowired
	private GoalRepository goalRepo;
	
	@Override
	public Boolean createGoalAndSprints(GoalDto newGoal){
		GoalEntity goal = new GoalEntity();
		goal.setUser_id(newGoal.getUser_id());
		goal.setSlogan(newGoal.getSlogan());
		goal.setStart_weight(newGoal.getStart_weight());
		goal.setStart_date(newGoal.getStart_date());
		goal.setGoal_weight(newGoal.getGoal_weight());
		goal.setGoal_date(newGoal.getGoal_date());
		goal.setSprintSpan(newGoal.getSprintSpan());
		generateAndSaveSprints(goal);
		return true;
	}
	private void generateAndSaveSprints(GoalEntity goal) {
		ZonedDateTime dateCounter = goal.getStart_date();
		Long goalId = goal.getId();
		Long userId = goal.getUser_id();
		long sprintSpan = goal.getSprintSpan();
		while(dateCounter.isBefore(goal.getGoal_date())){
			Sprint sprint = new Sprint();
			sprint.setGoal_id(goalId);
			sprint.setUser_id(userId);
			sprint.setStart_date(dateCounter);
			sprint.setGoal_date(dateCounter.plusDays(sprintSpan));
			saveSprint(sprint);
			dateCounter = dateCounter.plusDays(sprintSpan);
		}
	}

	@Override
	public void saveSprint(Sprint sprint){
		sprintRepo.save(sprint);
	}

}
