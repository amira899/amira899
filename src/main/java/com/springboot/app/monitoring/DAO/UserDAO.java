package com.springboot.app.monitoring.DAO;

import java.util.List;

import com.springboot.app.monitoring.model.CheckPasswordDTO;
import com.springboot.app.monitoring.model.User;

  public interface UserDAO {
    public List<User> findAllusers();
    public User findById(Long iduser);
    public void ChangePassword(String password, long iduser);
    public List<User> CheckPassword(CheckPasswordDTO checkPasswordDTO);
}