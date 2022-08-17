package com.springboot.app.monitoring.service;

import java.util.List;

import com.springboot.app.monitoring.model.ResultMoisStatistique;
import com.springboot.app.monitoring.model.ResultSearchStatistique;
import com.springboot.app.monitoring.model.StatistiqueSearchDTO;
import com.springboot.app.monitoring.model.StatistiqueTypeProcess;
import com.springboot.app.monitoring.model.StatistiqueUserIdentity;



public interface StatistiqueService {
	public List<ResultSearchStatistique> countNombreStatus(StatistiqueSearchDTO statistiqueSearchDTO);
	public List<ResultSearchStatistique> countNombreProcessFail(StatistiqueSearchDTO statistiqueSearchDTO);
	public List<ResultMoisStatistique> countNbProcessParMois();
	public List<StatistiqueTypeProcess> countNbProcessType();
	public List<StatistiqueUserIdentity> countNbProcessStartedByUser();
	public int countNbProcessEncours();
	public int countNbProcessAnnulee();
	public int countNbProcessCompletee();
	
}
