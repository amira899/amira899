package com.springboot.app.monitoring.DAO;

import java.math.BigInteger;
import java.util.List;

import com.springboot.app.monitoring.model.AnnulationDTO;
import com.springboot.app.monitoring.model.AnnulationSearchDTO;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;

public interface AnnulationDAO {
	public   List<AnnulationDTO> getProcessEncours(AnnulationDTO annulationDTO);
	public   List<AnnulationDTO> SearchProcessEncours(AnnulationSearchDTO annulationSearchDTO);
	public List<ProcessDetails> findByProcessInstanceId(long processInstanceId);
	public List<DetailsTache> getDetailsTache(long processInstanceId);
	public  void updateByProcessInstanceId(BigInteger processInstanceId);
}