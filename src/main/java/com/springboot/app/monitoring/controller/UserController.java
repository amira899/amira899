package com.springboot.app.monitoring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.monitoring.Repository.UserRepository;
import com.springboot.app.monitoring.exception.ResourceNotFoundException;
import com.springboot.app.monitoring.model.CheckPasswordDTO;
import com.springboot.app.monitoring.model.User;
import com.springboot.app.monitoring.serviceImpl.UserServiceImpl;
import io.swagger.annotations.Api;
@CrossOrigin(origins = "*")
@RestController
@Api(value="user Controller", description="operations to manage persons")
public class UserController {
@Autowired
private UserRepository userRepository;
@Autowired
private UserServiceImpl userServiceImpl;
//get all Users
@GetMapping("/users")
public List<User> getAllUsers(){
return userRepository.findAll();
}
//create User rest api
@PostMapping("/users")
public User createUser (@RequestBody User user){
return userRepository.save(user);
}
//get User by id rest api
@GetMapping("/users/{iduser}")
public ResponseEntity<User> getUserById(@PathVariable Long iduser) {
	User user = userRepository.findById(iduser)
  .orElseThrow(() ->new ResourceNotFoundException("User not exist with id :" + iduser));
	return ResponseEntity.ok(user);
}
//update User rest api
@PutMapping("/users/updateUser/{iduser}")
public ResponseEntity<User> updateUser(@PathVariable Long iduser, @RequestBody User userDetails){
	User user = userRepository.findById(iduser)
	 .orElseThrow(() ->new ResourceNotFoundException("User not exist with id :" + iduser));
	user.setUserName(userDetails.getUserName());
	user.setPassword(userDetails.getPassword());
	User updatedUser = userRepository.save(user);
	 return ResponseEntity.ok(updatedUser);			
}
// delete User rest api
@DeleteMapping("/users/{iduser}")
public ResponseEntity<Map<String, Boolean>> deleteUser( @PathVariable Long iduser){
	User user = userRepository.findById(iduser)
 .orElseThrow(() ->new ResourceNotFoundException("User not exist with id :" + iduser));
	userRepository.delete(user);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
}
@PostMapping("/users/check/")
public List<User> CheckPassword(@RequestBody CheckPasswordDTO checkPasswordDTO)	{
	return userServiceImpl.CheckPassword(checkPasswordDTO);
}
}