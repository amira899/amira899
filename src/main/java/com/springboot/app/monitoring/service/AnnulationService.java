package com.springboot.app.monitoring.service;

import java.math.BigInteger;
import java.util.List;

import com.springboot.app.monitoring.model.AnnulationDTO;
import com.springboot.app.monitoring.model.AnnulationSearchDTO;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;


public interface AnnulationService {
	public  List<AnnulationDTO> getProcessEncours(AnnulationDTO AnnulationDTO);
	public   List<AnnulationDTO> getProcessEncours(AnnulationSearchDTO annulationSearchDTO);
	public List<ProcessDetails> getByProcessInstanceId(long processInstanceId);
	public List<DetailsTache> getDetailsTache(long processInstanceId);
	public void updateByProcessInstanceId(BigInteger processInstanceId);
}
