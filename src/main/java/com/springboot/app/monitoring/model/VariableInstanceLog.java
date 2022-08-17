package com.springboot.app.monitoring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity 
public class VariableInstanceLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	@Column
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	 private LocalDateTime log_date;
	@Column( length = 255)
	private String externalId;
	@Column( length = 255)
	private String oldValue;
	@Column( length = 255)
	private String processId;
	@Column
	 private long processInstanceId;
	@Column( length = 255)
	private String value;
	@Column( length = 255)
	private String variableId;
	@Column( length = 255)
	private String variableInstanceId;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDateTime getLog_date() {
		return log_date;
	}
	public void setLog_date(LocalDateTime log_date) {
		this.log_date = log_date;
	}
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	public String getOldValue() {
		return oldValue;
	}
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public long getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(long processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getVariableId() {
		return variableId;
	}
	public void setVariableId(String variableId) {
		this.variableId = variableId;
	}
	public String getVariableInstanceId() {
		return variableInstanceId;
	}
	public void setVariableInstanceId(String variableInstanceId) {
		this.variableInstanceId = variableInstanceId;
	}
	@Override
	public String toString() {
		return "VariableInstanceLog [id=" + id + ", log_date=" + log_date + ", externalId=" + externalId + ", oldValue="
				+ oldValue + ", processId=" + processId + ", processInstanceId=" + processInstanceId + ", value="
				+ value + ", variableId=" + variableId + ", variableInstanceId=" + variableInstanceId + "]";
	}
}