package com.machworks.weightbacklog.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sprint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long goal_id;
	private Long user_id;
	private Float start_weight;
	private ZonedDateTime start_date;
	private Float goal_weight;
	private Float end_weight;
	private ZonedDateTime goal_date;

}
