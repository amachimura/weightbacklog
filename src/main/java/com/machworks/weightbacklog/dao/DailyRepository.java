package com.machworks.weightbacklog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machworks.weightbacklog.entity.DailyWeight;

@Repository
public interface DailyRepository extends JpaRepository<DailyWeight, Long> {

}
