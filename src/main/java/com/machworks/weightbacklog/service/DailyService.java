package com.machworks.weightbacklog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.machworks.weightbacklog.dao.DailyRepository;

@Component
public class DailyService {
	@Autowired
	private DailyRepository dailyRepo;
	
	

}
