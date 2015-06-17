package com.machworks.weightbacklog.dao;

import java.time.ZonedDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.machworks.weightbacklog.entity.GoalEntity;

@Repository
public interface GoalRepository extends JpaRepository<GoalEntity, Long> {
	@Query(value = "SELECT g FROM GoalEntity g WHERE :date BETWEEN g.start_date AND g.goal_date AND :userId = g.user_id")
	GoalEntity findByDate(@Param("date")ZonedDateTime date, @Param("userId")long userId);
}
