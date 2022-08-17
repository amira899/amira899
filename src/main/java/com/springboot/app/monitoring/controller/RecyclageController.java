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

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.RecyclageDTO;
import com.springboot.app.monitoring.model.RecyclageSearchDTO;
import com.springboot.app.monitoring.serviceImpl.RecyclageServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value="Recyclage Controller")
public class RecyclageController {
	@Autowired
	 private RecyclageServiceImpl recyclageServiceImpl;
	 @GetMapping("/recyclage")
    public List<RecyclageDTO> getFailedProcess(RecyclageDTO recyclageDTO) {
        List<RecyclageDTO> Failedprocess = recyclageServiceImpl.getFailedProcess(recyclageDTO);
        return Failedprocess;
    }
	 @PostMapping("/recyclage")
	 public   List<RecyclageDTO> SearchFailedProcess( @RequestBody RecyclageSearchDTO recyclageSearchDTO){
     return recyclageServiceImpl.getFailedProcess(recyclageSearchDTO);
     }
	 @PutMapping("/recyclage/updateFromReadyToCompleted/{processInstanceId}")
		public void updateByProcessInstanceId( @PathVariable BigInteger processInstanceId) {
	        recyclageServiceImpl.updateByProcessInstanceId(processInstanceId);
	    }
	 @GetMapping("/recyclage/{processInstanceId}")
	   public List<ProcessDetails> findByProcessInstanceId(@PathVariable long processInstanceId) {
	     List<ProcessDetails> process =  recyclageServiceImpl.getByProcessInstanceId(processInstanceId);
	       return process;
	   }
	 @GetMapping("/recyclage/tacheDetails/{processInstanceId}")
	   public List<DetailsTache> getDetailsTache(@PathVariable long processInstanceId) {
	     List<DetailsTache> process = recyclageServiceImpl.getDetailsTache(processInstanceId);
	       return process;
	   }
	 @GetMapping("/recyclage/count/{processInstanceId}")
	 public int countNombreRecyclage(long processInstanceId) {
	   return  recyclageServiceImpl.countNombreRecyclage(processInstanceId);
	   }
}
