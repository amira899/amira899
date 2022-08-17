package com.springboot.app.monitoring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.monitoring.model.User;



public interface LoginRepository extends JpaRepository <User, Long> {

	User findByUserName(String userName);

}
