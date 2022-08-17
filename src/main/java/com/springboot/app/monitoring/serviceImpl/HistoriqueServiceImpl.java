package com.springboot.app.monitoring.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.monitoring.DAO.HistoriqueDAOImpl;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.ResultSearchCriterea;
import com.springboot.app.monitoring.model.SearchCriterea;
import com.springboot.app.monitoring.service.HistoriqueService;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {
	 @Autowired
	    HistoriqueDAOImpl processDAOImpl;

	 @Override
	 public  List<ResultSearchCriterea>  SearchProcess(SearchCriterea searchCriterea) {
	 return processDAOImpl.SearchProcess(searchCriterea);
	 }
	  
	 public List<ResultSearchCriterea> getallProcess(ResultSearchCriterea resultSearchCriterea){
		 return processDAOImpl. getProcess(resultSearchCriterea);
	 }
	 public List<ProcessDetails> getByProcessInstanceId(long processInstanceId) {
		 return processDAOImpl. findByProcessInstanceId(processInstanceId);
	 }

	@Override
	public List<DetailsTache> getDetailsTache(long processInstanceId) {
		 return processDAOImpl.getDetailsTache(processInstanceId);
	}
	 }