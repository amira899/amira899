package com.springboot.app.monitoring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
	
}