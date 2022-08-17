package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class ResultSearchCriterea {
	private String start_date;
	private String end_date;
	private int status;
	private BigInteger processInstanceId;
	private String processId;
	
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	

	public BigInteger getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(BigInteger processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	
}
