package com.springboot.app.monitoring.DAO;

import java.util.List;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.ResultSearchCriterea;
import com.springboot.app.monitoring.model.SearchCriterea;

public interface HistoriqueDAO {
	public   List<ResultSearchCriterea> getProcess(ResultSearchCriterea resultSearchCriterea);
	public   List<ResultSearchCriterea> SearchProcess(SearchCriterea searchCriterea);
	public List<ProcessDetails> findByProcessInstanceId(long processInstanceId);
	public List<DetailsTache> getDetailsTache(long processInstanceId);
}