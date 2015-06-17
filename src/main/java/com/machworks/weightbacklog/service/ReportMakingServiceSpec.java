package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.DailyWeightDto;
import com.machworks.weightbacklog.entity.User;

public interface ReportMakingServiceSpec {
	String saveAndReport(User user, DailyWeightDto data);

	String generateReport(User user, DailyWeightDto data);

}
