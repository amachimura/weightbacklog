package com.machworks.weightbacklog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.machworks.weightbacklog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
