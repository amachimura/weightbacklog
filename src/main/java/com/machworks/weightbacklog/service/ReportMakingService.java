package com.machworks.weightbacklog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.machworks.weightbacklog.dao.DailyRepository;
import com.machworks.weightbacklog.dao.GoalRepository;
import com.machworks.weightbacklog.dao.SprintRepository;

@Component
public class ReportMakingService {
	@Autowired
	DailyRepository dailyRepo;
	@Autowired
	private SprintRepository sprintRepo;
	@Autowired
	private GoalRepository goalRepo;
	

}
