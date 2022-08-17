package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class StatistiqueUserIdentity {
           private BigInteger processAdmin;
           private BigInteger processUnknown;
		public BigInteger getProcessAdmin() {
			return processAdmin;
		}
		public void setProcessAdmin(BigInteger processAdmin) {
			this.processAdmin = processAdmin;
		}
		public BigInteger getProcessUnknown() {
			return processUnknown;
		}
		public void setProcessUnknown(BigInteger processUnknown) {
			this.processUnknown = processUnknown;
		}     
}