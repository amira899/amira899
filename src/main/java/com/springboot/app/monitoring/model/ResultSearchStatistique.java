package com.springboot.app.monitoring.model;

import java.math.BigInteger;

public class ResultSearchStatistique {
      private BigInteger   processEncours;
      private BigInteger processCompleted;
      private BigInteger processAnnulee;
      private BigInteger allProcess;
      private BigInteger nbFailProcess;
      private BigInteger nbTaskProcess;
    
      
	public BigInteger getProcessEncours() {
		return processEncours;
	}
	public void setProcessEncours(BigInteger processEncours) {
		this.processEncours = processEncours;
	}
	public BigInteger getProcessCompleted() {
		return processCompleted;
	}
	public void setProcessCompleted(BigInteger processCompleted) {
		this.processCompleted = processCompleted;
	}
	public BigInteger getProcessAnnulee() {
		return processAnnulee;
	}
	public void setProcessAnnulee(BigInteger processAnnulee) {
		this.processAnnulee = processAnnulee;
	}
	public BigInteger getAllProcess() {
		return allProcess;
	}
	public void setAllProcess(BigInteger allProcess) {
		this.allProcess = allProcess;
	}
	public BigInteger getNbFailProcess() {
		return nbFailProcess;
	}
	public void setNbFailProcess(BigInteger nbFailProcess) {
		this.nbFailProcess = nbFailProcess;
	}
	public BigInteger getNbTaskProcess() {
		return nbTaskProcess;
	}
	public void setNbTaskProcess(BigInteger nbTaskProcess) {
		this.nbTaskProcess = nbTaskProcess;
	}
	
	
	
	
     
	
	
      
      
}
