package com.springboot.app.monitoring.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
@Entity 
public class ProcessInstanceLog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private long id;
	@Column( length = 255)
	private String correlationKey;
	@Column
	 private long duration;
 @Column
 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
 private LocalDateTime end_date;
 @Column( length = 255)
	private String externalId;
 @Column( length = 255)
	private String user_identity;
 @Column( length = 255)
	private String outcome;
 @Column
 private long parentProcessInstanceId;
 @Column( length = 255)
	private String processId;
 @Column( length = 255)
	private String processInstanceDescription;
 @Column
 private long processInstanceId;
 @Column( length = 255)
	private String processName;
 @Column( length = 255)
	private String processVersion;
 @Column
 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
 private LocalDateTime start_date;
 @Column
 private int status;
 @Column( length = 255)
	private String statusprod;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getCorrelationKey() {
	return correlationKey;
}
public void setCorrelationKey(String correlationKey) {
	this.correlationKey = correlationKey;
}
public long getDuration() {
	return duration;
}
public void setDuration(long duration) {
	this.duration = duration;
}



public LocalDateTime getEnd_date() {
	return end_date;
}
public void setEnd_date(LocalDateTime end_date) {
	this.end_date = end_date;
}
public LocalDateTime getStart_date() {
	return start_date;
}
public void setStart_date(LocalDateTime start_date) {
	this.start_date = start_date;
}
public String getExternalId() {
	return externalId;
}
public void setExternalId(String externalId) {
	this.externalId = externalId;
}
public String getUser_identity() {
	return user_identity;
}
public void setUser_identity(String user_identity) {
	this.user_identity = user_identity;
}
public String getOutcome() {
	return outcome;
}
public void setOutcome(String outcome) {
	this.outcome = outcome;
}
public long getParentProcessInstanceId() {
	return parentProcessInstanceId;
}
public void setParentProcessInstanceId(long parentProcessInstanceId) {
	this.parentProcessInstanceId = parentProcessInstanceId;
}
public String getProcessId() {
	return processId;
}
public void setProcessId(String processId) {
	this.processId = processId;
}
public String getProcessInstanceDescription() {
	return processInstanceDescription;
}
public void setProcessInstanceDescription(String processInstanceDescription) {
	this.processInstanceDescription = processInstanceDescription;
}
public long getProcessInstanceId() {
	return processInstanceId;
}
public void setProcessInstanceId(long processInstanceId) {
	this.processInstanceId = processInstanceId;
}
public String getProcessName() {
	return processName;
}
public void setProcessName(String processName) {
	this.processName = processName;
}
public String getProcessVersion() {
	return processVersion;
}
public void setProcessVersion(String processVersion) {
	this.processVersion = processVersion;
}

public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getStatusprod() {
	return statusprod;
}
public void setStatusprod(String statusprod) {
	this.statusprod = statusprod;
}
@Override
public String toString() {
	return "ProcessInstanceLog [id=" + id + ", correlationKey=" + correlationKey + ", duration=" + duration
			+ ", end_date=" + end_date + ", externalId=" + externalId + ", user_identity=" + user_identity
			+ ", outcome=" + outcome + ", parentProcessInstanceId=" + parentProcessInstanceId + ", processId="
			+ processId + ", processInstanceDescription=" + processInstanceDescription + ", processInstanceId="
			+ processInstanceId + ", processName=" + processName + ", processVersion=" + processVersion
			+ ", start_date=" + start_date + ", status=" + status + ", statusprod=" + statusprod + "]";
}
}