package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class RecyclageSearchDTO {
	 private BigInteger processInstanceId;
	 private String end_date;
		private String start_date;
		private String co_id;
		private String formName;
		
		public BigInteger getProcessInstanceId() {
			return processInstanceId;
		}
		public void setProcessInstanceId(BigInteger processInstanceId) {
			this.processInstanceId = processInstanceId;
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
		public String getFormName() {
			return formName;
		}
		public void setFormName(String formName) {
			this.formName = formName;
		}
		
}
