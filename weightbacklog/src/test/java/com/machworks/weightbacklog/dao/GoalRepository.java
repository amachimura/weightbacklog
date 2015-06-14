package com.machworks.weightbacklog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machworks.weightbacklog.entity.GoalEntity;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {

}
