package com.springboot.app.monitoring.service;

import java.util.List;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.ResultSearchCriterea;
import com.springboot.app.monitoring.model.SearchCriterea;

public interface HistoriqueService {
	public  List<ResultSearchCriterea>  SearchProcess(SearchCriterea searchCriterea);
	public   List<ResultSearchCriterea> getallProcess(ResultSearchCriterea resultSearchCriterea);
	public List<ProcessDetails> getByProcessInstanceId(long processInstanceId);
	public List<DetailsTache> getDetailsTache(long processInstanceId);
}