package com.machworks.weightbacklog.entity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DailyWeight {
	@Id
	@GeneratedValue
	private Long id;
	private Long sprint_id;
	private Long user_id;
	private ZonedDateTime today_date;
	private Float weight;
}
