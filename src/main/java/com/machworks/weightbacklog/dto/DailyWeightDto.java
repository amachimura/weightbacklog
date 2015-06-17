package com.machworks.weightbacklog.dto;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class DailyWeightDto {
	private Long user_id;
	private ZonedDateTime today_date;
	private Float weight;
	private boolean toFacebook;
}
