package com.springboot.app.monitoring.DAO;

import java.util.List;

import com.springboot.app.monitoring.model.ResultSearchStatistique;
import com.springboot.app.monitoring.model.StatistiqueSearchDTO;


public interface StatistiqueDAO {
	public List<ResultSearchStatistique> countNombreStatus(StatistiqueSearchDTO statistiqueSearchDTO);
	public List<ResultSearchStatistique> countNombreProcessFail(StatistiqueSearchDTO statistiqueSearchDTO);
}
