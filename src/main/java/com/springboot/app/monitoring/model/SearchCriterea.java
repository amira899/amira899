package com.springboot.app.monitoring.model;

public class SearchCriterea {
	private String processId;
	private int processInstanceId;
	private int status;
	private String end_date;
	private String start_date;
	private String co_id;
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getCo_id() {
		return co_id;
	}
	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}
	public int getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(int processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	
	
}
