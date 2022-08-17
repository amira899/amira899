package com.springboot.app.monitoring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.monitoring.DAO.StatistiqueDAOImpl;
import com.springboot.app.monitoring.DAO.StatistiqueDashboardImpl;
import com.springboot.app.monitoring.model.ResultMoisStatistique;
import com.springboot.app.monitoring.model.ResultSearchStatistique;
import com.springboot.app.monitoring.model.StatistiqueSearchDTO;
import com.springboot.app.monitoring.model.StatistiqueTypeProcess;
import com.springboot.app.monitoring.model.StatistiqueUserIdentity;
import com.springboot.app.monitoring.service.StatistiqueService;

@Service
public class StatistiqueServiceImpl implements StatistiqueService {
	 @Autowired
	    StatistiqueDAOImpl statistiqueDAOImpl;
	 @Autowired
        StatistiqueDashboardImpl dashboardStatistiqueImpl;
	 @Override
	 public  List<ResultSearchStatistique> countNombreStatus(StatistiqueSearchDTO statistiqueSearchDTO) {
	 return statistiqueDAOImpl.countNombreStatus(statistiqueSearchDTO);
	 }
	 @Override
	 public  List<ResultSearchStatistique> countNombreProcessFail(StatistiqueSearchDTO statistiqueSearchDTO) {
	 return statistiqueDAOImpl.countNombreProcessFail(statistiqueSearchDTO);
	 }
	 @Override
	 public List<ResultMoisStatistique> countNbProcessParMois() {
	 return dashboardStatistiqueImpl.countNbProcessParMois();
	 }
	 @Override
	 public List<StatistiqueTypeProcess> countNbProcessType() {
	 return dashboardStatistiqueImpl.countNbProcessType();
	 }
	 
	 @Override
	 public List<StatistiqueUserIdentity> countNbProcessStartedByUser() {
	 return dashboardStatistiqueImpl.countNbProcessStartedByUser();
	 }
	 @Override
	 public int countNbProcessEncours() {
	 return dashboardStatistiqueImpl.countNbProcessEncours();
	 }
	 
	 @Override
	 public int countNbProcessAnnulee() {
	 return dashboardStatistiqueImpl.countNbProcessAnnulee();
	 }
	 @Override
	 public int countNbProcessCompletee() {
	 return dashboardStatistiqueImpl.countNbProcessCompletee();
	 }
}
