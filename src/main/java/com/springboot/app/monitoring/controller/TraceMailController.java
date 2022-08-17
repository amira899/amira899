package com.springboot.app.monitoring.controller;

import java.math.BigInteger;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.monitoring.DAO.HistoriqueDAOImpl;
import com.springboot.app.monitoring.model.ResultTraceMail;
import com.springboot.app.monitoring.model.TraceMail;
import com.springboot.app.monitoring.serviceImpl.TraceMailServiceImpl;
import io.swagger.annotations.Api;

@CrossOrigin(origins = "*")
@RestController
@Api(value="traceMail Controller")
public class TraceMailController {
	 org.slf4j.Logger logger = LoggerFactory.getLogger(HistoriqueDAOImpl.class);

	 @Autowired
	 private TraceMailServiceImpl traceMailServiceImpl;
	
	 @PostMapping("/traceMail")
	 public   List<ResultTraceMail> SearchTraceMail( @RequestBody TraceMail traceMailSearch){
		 logger.info("traceMailSearch.getRECEIVER()="+traceMailSearch.getReceiver());
     return traceMailServiceImpl.getTraceMail(traceMailSearch);
     }
}