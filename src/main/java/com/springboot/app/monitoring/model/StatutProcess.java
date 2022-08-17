package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class StatutProcess {
	private BigInteger processAnnulee;
	private BigInteger processCompletee;
	private BigInteger processEncours;
	
	
	public BigInteger getProcessAnnulee() {
		return processAnnulee;
	}
	public void setProcessAnnulee(BigInteger processAnnulee) {
		this.processAnnulee = processAnnulee;
	}
	
	public BigInteger getProcessCompletee() {
		return processCompletee;
	}
	public void setProcessCompletee(BigInteger processCompletee) {
		this.processCompletee = processCompletee;
	}
	public BigInteger getProcessEncours() {
		return processEncours;
	}
	public void setProcessEncours(BigInteger processEncours) {
		this.processEncours = processEncours;
	}      
}
