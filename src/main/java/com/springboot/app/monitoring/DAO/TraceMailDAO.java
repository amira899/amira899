package com.springboot.app.monitoring.DAO;

import java.util.List;

import com.springboot.app.monitoring.model.ResultTraceMail;
import com.springboot.app.monitoring.model.TraceMail;

public interface TraceMailDAO {
	public   List<ResultTraceMail> SearchTraceMail(TraceMail traceMail);
}