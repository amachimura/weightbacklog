package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.entity.GoalEntity;
import com.machworks.weightbacklog.entity.Sprint;

import java.util.List;

public interface MasterDataServiceSpec {
	Boolean createGoalAndSprints(GoalDto newGoal);

	void saveSprint(Sprint sprint);

	List<Sprint> generateSprints(GoalEntity goal);
}
