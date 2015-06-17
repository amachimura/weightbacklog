package com.machworks.weightbacklog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.machworks.weightbacklog.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
