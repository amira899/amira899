package com.springboot.app.monitoring.DAO;

import java.math.BigInteger;
import java.util.List;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.RecyclageDTO;
import com.springboot.app.monitoring.model.RecyclageSearchDTO;

public interface RecyclageDAO {
	public   List<RecyclageDTO> getFailedProcess(RecyclageDTO recyclageDTO);
	public   List<RecyclageDTO> SearchFailedProcess(RecyclageSearchDTO recyclageSearchDTO);
	public  void updateByProcessInstanceId(BigInteger processInstanceId);
	public List<ProcessDetails> findByProcessInstanceId(long processInstanceId);
	public List<DetailsTache> getDetailsTache(long processInstanceId);
	public int countNombreRecyclage(long processInstanceId);
}
