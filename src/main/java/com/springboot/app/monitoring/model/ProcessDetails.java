package com.springboot.app.monitoring.model;

public class ProcessDetails {
	private String variableId;
	 private String log_date;
		private String value;
		public String getVariableId() {
			return variableId;
		}
		public void setVariableId(String variableId) {
			this.variableId = variableId;
		}
		public String getLog_date() {
			return log_date;
		}
		public void setLog_date(String log_date) {
			this.log_date = log_date;
		}
		public String getValue() {
			return value;
		}	
		public void setValue(String value) {
			this.value = value;
		}
		
		
}
