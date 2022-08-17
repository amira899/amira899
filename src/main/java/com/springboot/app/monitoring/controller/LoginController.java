package com.springboot.app.monitoring.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.app.monitoring.DAO.UserDAOImpl;
import com.springboot.app.monitoring.Repository.LoginRepository;
import com.springboot.app.monitoring.model.Role;
import com.springboot.app.monitoring.model.User;
import com.springboot.app.monitoring.model.UserAuth;
import com.springboot.app.monitoring.serviceImpl.UserServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	UserServiceImpl userService ;
	@Autowired
	UserDAOImpl userDAO;
	@RequestMapping(value="/login/{userName}", method=RequestMethod.GET)
	private UserAuth getUserByUsernamePassword(@PathVariable("userName") String userName) {
	User user =loginRepository.findByUserName(userName);

	System.out.println (user.toString());
	Optional<Role> role = userService.getRoleByName(user.getRoleid());
	UserAuth userAuth = new UserAuth();
	userAuth.setIduser(user.getIduser());
	userAuth.setUserName(user.getUserName());
	userAuth.setPassword(user.getPassword());
	userAuth.setRoleName(role.get().getRoleName());
	return userAuth;
	}
	  @GetMapping("/login1/{iduser}")
	 	public User getuserbyid(@PathVariable Long iduser){
	 	return userDAO.findById(iduser);
	 	}	 
	}