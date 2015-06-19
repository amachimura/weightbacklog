package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.entity.Sprint;

public interface MasterDataServiceSpec {
	Boolean createGoalAndSprints(GoalDto newGoal);

	void saveSprint(Sprint sprint);
}
