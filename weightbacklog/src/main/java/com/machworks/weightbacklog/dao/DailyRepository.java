package com.machworks.weightbacklog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machworks.weightbacklog.entity.DailyWeight;

public interface DailyRepository extends JpaRepository<DailyWeight, Long> {

}
