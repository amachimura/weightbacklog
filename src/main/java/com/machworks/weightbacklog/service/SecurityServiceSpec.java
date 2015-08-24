package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.UserDto;

public interface SecurityServiceSpec {
	String registerUser(UserDto user);
	boolean isExistUser(UserDto user);
	Long generateId();
	boolean isValidPass(UserDto user);
}
