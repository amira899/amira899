package com.springboot.app.monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.monitoring.model.ResultMoisStatistique;
import com.springboot.app.monitoring.model.ResultSearchStatistique;
import com.springboot.app.monitoring.model.StatistiqueSearchDTO;
import com.springboot.app.monitoring.model.StatistiqueTypeProcess;
import com.springboot.app.monitoring.model.StatistiqueUserIdentity;
import com.springboot.app.monitoring.serviceImpl.StatistiqueServiceImpl;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value="Statistique Controller")
public class StatistiqueController {
	 @Autowired
	 private StatistiqueServiceImpl statistiqueServiceImpl;
    
     @PostMapping("/statistique/taches")
     public  List<ResultSearchStatistique> countNombreStatus( @RequestBody StatistiqueSearchDTO statistiqueSearchDTO){
     return statistiqueServiceImpl.countNombreStatus(statistiqueSearchDTO);
     }  
     @PostMapping("/statistique/failProcess")
     public  List<ResultSearchStatistique> countNombreProcessFail( @RequestBody StatistiqueSearchDTO statistiqueSearchDTO){
     return statistiqueServiceImpl.countNombreProcessFail(statistiqueSearchDTO);
     }  
     @GetMapping("/statistique/MoisProcess")
     public List<ResultMoisStatistique> countNbProcessParMois(){
     return statistiqueServiceImpl.countNbProcessParMois();
     }  
     @GetMapping("/statistique/TypeProcess")
     public List<StatistiqueTypeProcess> countNbProcessType(){
     return statistiqueServiceImpl.countNbProcessType();
     }  
     @GetMapping("/statistique/userIdentity")
     public List<StatistiqueUserIdentity> countNbProcessStartedByUser(){
     return statistiqueServiceImpl.countNbProcessStartedByUser();
     } 
     @GetMapping("/statistique/PEncours")
     public int countNbProcessEncours(){
     return statistiqueServiceImpl.countNbProcessEncours();
     }  
     @GetMapping("/statistique/PAnnulee")
     public int countNbProcessAnuulee(){
     return statistiqueServiceImpl.countNbProcessAnnulee();
     }  
     @GetMapping("/statistique/PCompletee")
     public int countNbProcessCompletee(){
     return statistiqueServiceImpl.countNbProcessCompletee();
     }  
}
