package com.machworks.weightbacklog.controller.viewentity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class DailyWeightViewEntity {
	private Long userId;
	private Long sprintId;
	private ZonedDateTime todayDate;
	private Float weight;
	private boolean toFacebook;
}
