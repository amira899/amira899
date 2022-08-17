package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class AnnulationDTO {
	 private BigInteger processInstanceId;
	 private String processId;
	 private int status;
		private String start_date;
		
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
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getStart_date() {
			return start_date;
		}
		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}
		
}
