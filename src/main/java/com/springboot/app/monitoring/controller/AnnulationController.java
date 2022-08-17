package com.springboot.app.monitoring.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.monitoring.model.AnnulationDTO;
import com.springboot.app.monitoring.model.AnnulationSearchDTO;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.serviceImpl.AnnulationServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value="Annulation Controller")
public class AnnulationController {
  
	 @Autowired
	 private AnnulationServiceImpl annulationServiceImpl;
	
	 @GetMapping("/annulation")
     public List<AnnulationDTO> getProcessEncours(AnnulationDTO annulationDTO) {
         List<AnnulationDTO> Annulationprocess = annulationServiceImpl.getProcessEncours(annulationDTO);
         return Annulationprocess;
     }
	 @PostMapping("/annulation")
	 public   List<AnnulationDTO> SearchProcessEncours( @RequestBody AnnulationSearchDTO annulationSearchDTO){
     return annulationServiceImpl.getProcessEncours(annulationSearchDTO);
     }
	 @GetMapping("/annulation/{processInstanceId}")
	   public List<ProcessDetails> findByProcessInstanceId(@PathVariable long processInstanceId) {
	     List<ProcessDetails> process = annulationServiceImpl.getByProcessInstanceId(processInstanceId);
	       return process;
	   }
	  @GetMapping("/annulation/tacheDetails/{processInstanceId}")
	   public List<DetailsTache> getDetailsTache(@PathVariable long processInstanceId) {
	     List<DetailsTache> process = annulationServiceImpl.getDetailsTache(processInstanceId);
	       return process;
	   }
	  @PutMapping("/annulation/updateFromEncoursToAnnulee/{processInstanceId}")
		public void updateByProcessInstanceId( @PathVariable BigInteger processInstanceId) {
		  annulationServiceImpl.updateByProcessInstanceId(processInstanceId);
	    }
   
}
