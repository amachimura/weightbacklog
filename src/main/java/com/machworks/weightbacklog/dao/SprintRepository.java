package com.machworks.weightbacklog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machworks.weightbacklog.entity.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
