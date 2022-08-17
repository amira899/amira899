package com.springboot.app.monitoring.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity 
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long iduser;
	@Column(nullable = false, unique = true, length = 45)
	private String userName;
	@Column(nullable = false, length = 64 )
	private String password;
 @Column
 private String roleid;
 @Column
 private String email;
 @Column
 private String tel;
	
	
	public Long getIduser() {
	return iduser;
}
public void setIduser(Long iduser) {
	this.iduser = iduser;
}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [iduser=" + iduser + ", userName=" + userName + ", password=" + password + ", roleid=" + roleid
				+ ", email=" + email + ", tel=" + tel + "]";
	}
}