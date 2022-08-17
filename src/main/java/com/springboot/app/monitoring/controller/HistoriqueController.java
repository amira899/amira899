package com.springboot.app.monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.ResultSearchCriterea;
import com.springboot.app.monitoring.model.SearchCriterea;
import com.springboot.app.monitoring.serviceImpl.HistoriqueServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value="Historique Controller")
public class HistoriqueController {
	 
     @Autowired
	 private HistoriqueServiceImpl processServiceImpl;
    
     @PostMapping("/process")
     public  List<ResultSearchCriterea>  SearchProcessByCriterea(@RequestBody SearchCriterea searchCriterea ){
     return processServiceImpl.SearchProcess(searchCriterea);
     }  
   @GetMapping("/process")
     public List<ResultSearchCriterea> getProcess(ResultSearchCriterea resultSearchCriterea) {
         List<ResultSearchCriterea> process = processServiceImpl.getallProcess(resultSearchCriterea);
         return process;
     }
   
   @GetMapping("/process/variableDetails/{processInstanceId}")
   public List<ProcessDetails> findByProcessInstanceId(@PathVariable long processInstanceId) {
     List<ProcessDetails> process = processServiceImpl.getByProcessInstanceId(processInstanceId);
       return process;
   }
   @GetMapping("/process/tacheDetails/{processInstanceId}")
   public List<DetailsTache> getDetailsTache(@PathVariable long processInstanceId) {
     List<DetailsTache> process = processServiceImpl.getDetailsTache(processInstanceId);
       return process;
   }
}
