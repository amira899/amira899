package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class RecyclageDTO {
	private BigInteger id;
	private String formName;
	private String activationTime;
	private String processId;
	private BigInteger processInstanceId;
	private String status;
	
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getActivationTime() {
		return activationTime;
	}
	public void setActivationTime(String activationTime) {
		this.activationTime = activationTime;
	}
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	
	
	
	public BigInteger getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(BigInteger processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
