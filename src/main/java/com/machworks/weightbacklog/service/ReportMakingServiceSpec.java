package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.DailyWeightDto;

public interface ReportMakingServiceSpec {
	String saveAndReport(DailyWeightDto data);

	String generateReport(DailyWeightDto data);

}
