package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.entity.Sprint;
import com.machworks.weightbacklog.entity.User;

public interface MasterDataServiceSpec {
	Boolean createGoalAndSprints(User user, GoalDto newGoal);

	void saveSprint(Sprint sprint);
}
