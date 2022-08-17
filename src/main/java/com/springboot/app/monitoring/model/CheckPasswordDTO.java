package com.springboot.app.monitoring.model;

public class CheckPasswordDTO {
	 private Long iduser;
	 private String password;
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CheckPasswordDTO() {
		super();
	}
	public CheckPasswordDTO(long iduser, String password) {
		super();
		this.iduser = iduser;
		this.password = password;
	}
	@Override
	public String toString() {
		return "CheckPasswordDTO [iduser=" + iduser + ", password=" + password + "]";
	}
	 
}
