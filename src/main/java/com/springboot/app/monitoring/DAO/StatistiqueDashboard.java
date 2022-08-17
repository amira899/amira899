package com.springboot.app.monitoring.DAO;

import java.util.List;

import com.springboot.app.monitoring.model.ResultMoisStatistique;
import com.springboot.app.monitoring.model.StatistiqueTypeProcess;
import com.springboot.app.monitoring.model.StatistiqueUserIdentity;

public interface StatistiqueDashboard {
	public List<ResultMoisStatistique> countNbProcessParMois();
	public List<StatistiqueTypeProcess> countNbProcessType();
	public List<StatistiqueUserIdentity> countNbProcessStartedByUser();
	public int countNbProcessEncours();
	public int countNbProcessAnnulee();
	public int countNbProcessCompletee();
}