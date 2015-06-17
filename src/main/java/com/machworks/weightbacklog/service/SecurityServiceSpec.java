package com.machworks.weightbacklog.service;

import com.machworks.weightbacklog.dto.UserDto;

public interface SecurityServiceSpec {
	String registerUser(UserDto user);
	boolean isValidUser(UserDto user);
}
