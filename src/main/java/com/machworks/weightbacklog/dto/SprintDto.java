package com.machworks.weightbacklog.dto;

import java.time.ZonedDateTime;

import lombok.Data;

@Data
public class SprintDto {
	private Long goal_id;
	private Long user_id;
	private String slogan;
	private Float start_weight;
	private ZonedDateTime start_date;
	private Float goal_weight;
	private Float end_weight;
	private ZonedDateTime goal_date;

}
