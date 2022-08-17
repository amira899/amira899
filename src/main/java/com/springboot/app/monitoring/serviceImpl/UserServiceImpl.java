package com.springboot.app.monitoring.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.monitoring.DAO.UserDAOImpl;
import com.springboot.app.monitoring.Repository.RoleRepository;
import com.springboot.app.monitoring.model.CheckPasswordDTO;
import com.springboot.app.monitoring.model.Role;
import com.springboot.app.monitoring.model.User;
import com.springboot.app.monitoring.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	  @Autowired
	    private RoleRepository roleRepository;
	  @Autowired
		UserDAOImpl userDAOImpl;
	  public Optional<Role> getRoleByName(String roleName) {
		   return roleRepository.findByRoleName(roleName);
		}
	  @Override
	  public List<User> CheckPassword(CheckPasswordDTO checkPasswordDTO){
			 return userDAOImpl.CheckPassword(checkPasswordDTO);
		 }
}