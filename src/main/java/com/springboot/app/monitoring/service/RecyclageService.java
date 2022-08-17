package com.springboot.app.monitoring.service;

import java.math.BigInteger;
import java.util.List;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.RecyclageDTO;
import com.springboot.app.monitoring.model.RecyclageSearchDTO;

public interface RecyclageService {
	public   List<RecyclageDTO> getFailedProcess(RecyclageDTO recyclageDTO);
	public   List<RecyclageDTO> getFailedProcess(RecyclageSearchDTO recyclageSearchDTO);
	public void updateByProcessInstanceId(BigInteger processInstanceId);
	public List<ProcessDetails> getByProcessInstanceId(long processInstanceId);
	public List<DetailsTache> getDetailsTache(long processInstanceId);
	public int countNombreRecyclage(long processInstanceId);
}