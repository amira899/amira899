package com.springboot.app.monitoring.service;

import java.util.List;

import com.springboot.app.monitoring.model.ResultTraceMail;
import com.springboot.app.monitoring.model.TraceMail;

public interface TraceMailService {
	public   List<ResultTraceMail> getTraceMail(TraceMail traceMail);

}
