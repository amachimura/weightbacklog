package com.machworks.weightbacklog.controller.viewentity;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class GoalViewEntity {
private Long userId;
private String slogan;
private Float startWeight;
private ZonedDateTime startDate;
private Float goalWeight;
private Float endWeight;
private ZonedDateTime goalDate;
private long sprintSpan;
}
