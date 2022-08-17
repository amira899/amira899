package com.springboot.app.monitoring.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.app.monitoring.DAO.TraceMailDAOImpl;
import com.springboot.app.monitoring.model.ResultTraceMail;
import com.springboot.app.monitoring.model.TraceMail;
import com.springboot.app.monitoring.service.TraceMailService;
@Service
public class TraceMailServiceImpl implements TraceMailService{
	@Autowired
	TraceMailDAOImpl traceMailDAOImpl;
	@Override
	public List<ResultTraceMail> getTraceMail(TraceMail traceMail) {
		 return traceMailDAOImpl. SearchTraceMail(traceMail);
	}
}