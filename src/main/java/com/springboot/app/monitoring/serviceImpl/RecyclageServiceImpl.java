package com.springboot.app.monitoring.serviceImpl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.monitoring.DAO.RecyclageDAOImpl;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.RecyclageDTO;
import com.springboot.app.monitoring.model.RecyclageSearchDTO;
import com.springboot.app.monitoring.service.RecyclageService;

@Service
public class RecyclageServiceImpl implements RecyclageService {

	@Autowired
	RecyclageDAOImpl recyclageDAOImpl;
	public  List<RecyclageDTO> getFailedProcess(RecyclageDTO recyclageDTO){
		 return recyclageDAOImpl. getFailedProcess(recyclageDTO);
	}
	@Override
	public List<RecyclageDTO> getFailedProcess(RecyclageSearchDTO recyclageSearchDTO) {
		return recyclageDAOImpl. SearchFailedProcess(recyclageSearchDTO);
	}
	@Override
	public void updateByProcessInstanceId(BigInteger processInstanceId) {
		recyclageDAOImpl.updateByProcessInstanceId(processInstanceId);
	}
	@Override
	 public List<ProcessDetails> getByProcessInstanceId(long processInstanceId) {
		 return recyclageDAOImpl. findByProcessInstanceId(processInstanceId);
	 }
	 @Override
		public List<DetailsTache> getDetailsTache(long processInstanceId) {
			 return recyclageDAOImpl.getDetailsTache(processInstanceId);
		}
	@Override
	public int countNombreRecyclage(long processInstanceId) {
		 return recyclageDAOImpl.countNombreRecyclage(processInstanceId);
	}
}