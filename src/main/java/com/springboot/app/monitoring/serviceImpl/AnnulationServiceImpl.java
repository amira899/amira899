package com.springboot.app.monitoring.serviceImpl;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.monitoring.DAO.AnnulationDAOImpl;
import com.springboot.app.monitoring.model.AnnulationDTO;
import com.springboot.app.monitoring.model.AnnulationSearchDTO;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.service.AnnulationService;

@Service
public class AnnulationServiceImpl  implements AnnulationService{
	@Autowired
	AnnulationDAOImpl AnnulationDAOImpl;
	public  List<AnnulationDTO> getProcessEncours(AnnulationDTO AnnulationDTO){
		 return AnnulationDAOImpl. getProcessEncours(AnnulationDTO);
	}
	@Override
	public List<AnnulationDTO> getProcessEncours(AnnulationSearchDTO annulationSearchDTO) {
		 return AnnulationDAOImpl. SearchProcessEncours(annulationSearchDTO);
	}
	 public List<ProcessDetails> getByProcessInstanceId(long processInstanceId) {
		 return AnnulationDAOImpl. findByProcessInstanceId(processInstanceId);
	 }
	 @Override
		public List<DetailsTache> getDetailsTache(long processInstanceId) {
			 return AnnulationDAOImpl.getDetailsTache(processInstanceId);
		}
	 @Override
		public void updateByProcessInstanceId(BigInteger processInstanceId) {
			AnnulationDAOImpl.updateByProcessInstanceId(processInstanceId);
		}
}