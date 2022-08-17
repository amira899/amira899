package com.springboot.app.monitoring.service;

import java.util.List;

import com.springboot.app.monitoring.model.CheckPasswordDTO;
import com.springboot.app.monitoring.model.User;

public interface UserService {
	public List<User> CheckPassword(CheckPasswordDTO checkPasswordDTO);
	
}

