package com.springboot.app.monitoring.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.ResultSearchStatistique;
import com.springboot.app.monitoring.model.StatistiqueSearchDTO;


@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Transactional
@Repository
public class StatistiqueDAOImpl implements StatistiqueDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${requestStatistique}")
	String requestStatistique;
	@Value("${requestStatistiqueFailProcess}")
	String requestStatistiqueFailProcess;
	@Value("${requestStatistiqueTaskProcess}")
	String requestStatistiqueTaskProcess;
	private SessionFactory sessionfactory;
	 org.slf4j.Logger logger = LoggerFactory.getLogger(StatistiqueDAOImpl.class);
	public StatistiqueDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		}
		public List<ResultSearchStatistique> countNombreStatus(StatistiqueSearchDTO statistiqueSearchDTO){
		 
			List<ResultSearchStatistique> listResult = new  ArrayList<ResultSearchStatistique>();
			   ResultSearchStatistique resultOfSearchCriterea = new ResultSearchStatistique();
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery = null; 
			   SQLQuery sqlQuery2 = null;
			   SQLQuery sqlQuery3 = null;
			   SQLQuery sqlQueryTotal = null;
			  
			   logger.info("start_date="+statistiqueSearchDTO.getStartDate());
			   logger.info("end_date="+statistiqueSearchDTO.getEndDate());
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
				 String querybuild=  requestStatistique;
				 boolean headQuery=false;
				 String querybuild2=  requestStatistique;
			     boolean headQuery2=false;
			     String querybuild3=  requestStatistique;
			     boolean headQuery3=false;
			     String querybuildTotal=  requestStatistique;
			     boolean headQueryTotal=false;
				
			    	querybuild=querybuild+" status =1";
			    	 headQuery=true;
			     if(statistiqueSearchDTO.getStartDate()!=null )
			     {
				   if(headQuery)querybuild=querybuild+" AND";
			    	querybuild=querybuild+" start_date BETWEEN CAST(:startDate AS DATE) AND  CAST((:endDate+ INTERVAL 1 DAY) AS DATE)";
			    	headQuery=true;
			     }
			     logger.info("querybuild = "+querybuild);
			     sqlQuery = session.createSQLQuery(querybuild);
			     
			    	querybuild2=querybuild2+" status =2";
			    	 headQuery2=true;
			     if(statistiqueSearchDTO.getStartDate()!=null )
			     {
				   if(headQuery2)querybuild2=querybuild2+" AND";
			    	querybuild2=querybuild2+" start_date BETWEEN CAST(:startDate AS DATE) AND  CAST((:endDate+ INTERVAL 1 DAY) AS DATE)";
			    	headQuery2=true;
			     }
			     logger.info("querybuild2 = "+querybuild2);
			     sqlQuery2 = session.createSQLQuery(querybuild2);
			     
			     
			     querybuild3=querybuild3+" status =3";
		    	 headQuery3=true;
		     if(statistiqueSearchDTO.getStartDate()!=null )
		     {
			   if(headQuery3)querybuild3=querybuild3+" AND";
		    	querybuild3=querybuild3+" start_date BETWEEN CAST(:startDate AS DATE) AND  CAST((:endDate+ INTERVAL 1 DAY) AS DATE)";
		    	headQuery3=true;
		     }
		     logger.info("querybuild3 = "+querybuild3);
		     sqlQuery3 = session.createSQLQuery(querybuild3);

	     if(statistiqueSearchDTO.getStartDate()!=null )
	     {
		   querybuildTotal=querybuildTotal+" start_date BETWEEN CAST(:startDate AS DATE) AND  CAST((:endDate+ INTERVAL 1 DAY) AS DATE)";
	    	headQueryTotal=true;
	     }
	     logger.info("querybuildTotal = "+querybuildTotal);
	     sqlQueryTotal = session.createSQLQuery(querybuildTotal);

	             if(statistiqueSearchDTO.getStartDate()!=null ) sqlQuery.setParameter("startDate", statistiqueSearchDTO.getStartDate());
			     if(statistiqueSearchDTO.getEndDate()!=null ) sqlQuery.setParameter("endDate", statistiqueSearchDTO.getEndDate());
			     List<BigInteger> rows = sqlQuery.list();
			     logger.info( "sizeresult=" +rows.size());
			     for(BigInteger row : rows){
				    resultOfSearchCriterea.setProcessEncours(row);
				    this.logger.info(  "result of processEnCours= " +resultOfSearchCriterea.getProcessEncours());  
				    listResult.add(resultOfSearchCriterea);
			       }
			    
	             if(statistiqueSearchDTO.getStartDate()!=null ) sqlQuery2.setParameter("startDate", statistiqueSearchDTO.getStartDate());
			     if(statistiqueSearchDTO.getEndDate()!=null ) sqlQuery2.setParameter("endDate", statistiqueSearchDTO.getEndDate());
			     List<BigInteger> rowscompleted = sqlQuery2.list();
			     logger.info( "sizeresult2=" +rowscompleted.size());
			     for(BigInteger row : rowscompleted){
				    resultOfSearchCriterea.setProcessCompleted(row);
				    this.logger.info(  "result of processCompleted= " +resultOfSearchCriterea.getProcessCompleted()); 
				  
			       } 
			     
			     if(statistiqueSearchDTO.getStartDate()!=null ) sqlQuery3.setParameter("startDate", statistiqueSearchDTO.getStartDate());
			     if(statistiqueSearchDTO.getEndDate()!=null ) sqlQuery3.setParameter("endDate", statistiqueSearchDTO.getEndDate());
			     List<BigInteger> rowsAnnulee = sqlQuery3.list();
			     logger.info( "sizeresult3=" +rowsAnnulee.size());
			     for(BigInteger row : rowsAnnulee){
				    resultOfSearchCriterea.setProcessAnnulee(row);
				    this.logger.info(  "result of processAnnulee= " +resultOfSearchCriterea.getProcessAnnulee()); 
				  
			       }
			     
			     if(statistiqueSearchDTO.getStartDate()!=null ) sqlQueryTotal.setParameter("startDate", statistiqueSearchDTO.getStartDate());
			     if(statistiqueSearchDTO.getEndDate()!=null ) sqlQueryTotal.setParameter("endDate", statistiqueSearchDTO.getEndDate());
			     List<BigInteger> rowsTotal = sqlQueryTotal.list();
			     logger.info( "sizeresultTotal=" +rowsTotal.size());
			     for(BigInteger row : rowsTotal){
				    resultOfSearchCriterea.setAllProcess(row);
				    this.logger.info(  "result of Allprocess= " +resultOfSearchCriterea.getAllProcess()); 
				  
			       }
			     
			      finished = Boolean.valueOf(true);
			     session.getTransaction().commit();      
			   }
			   catch (Exception e)
			   {
			     e.printStackTrace();
			     throw e;
			   }
			   finally
			   {
			     if ((session != null) && (session.isOpen())) {
			       session.close();
			     }
			   }
			   
			   this.logger.info("<=SearchProcess out finished with : " + finished);    
			   return  listResult;
		 }
	// ---------------statistique des fail process-----------------
		
		public List<ResultSearchStatistique> countNombreProcessFail(StatistiqueSearchDTO statistiqueSearchDTO){
			 
			List<ResultSearchStatistique> listResult = new  ArrayList<ResultSearchStatistique>();
			   ResultSearchStatistique resultOfSearchCriterea = new ResultSearchStatistique();
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery = null; 
			   SQLQuery sqlQuery2 = null;
			
			  
			   logger.info("start_date="+statistiqueSearchDTO.getStartDate());
			   logger.info("end_date="+statistiqueSearchDTO.getEndDate());
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
				 String querybuild=  requestStatistiqueFailProcess;
				 boolean headQuery=false;
				 String querybuild2=  requestStatistiqueTaskProcess;
			     boolean headQuery2=false;
			     
			 	querybuild=querybuild+"  status='Ready' ";
		    	 headQuery=true;
		    	 
		    	 if(headQuery)querybuild=querybuild+" AND";
			    	querybuild=querybuild+" name  like '%fail%' ";
			    	 headQuery=true;
			     if(statistiqueSearchDTO.getStartDate()!=null )
			     {
				   if(headQuery)querybuild=querybuild+" AND";
			    	querybuild=querybuild+" createdOn BETWEEN CAST(:startDate AS DATE) AND  CAST((:endDate+ INTERVAL 1 DAY) AS DATE)";
			    	headQuery=true;
			     }
			     logger.info("querybuild = "+querybuild);
			     sqlQuery = session.createSQLQuery(querybuild);
			     
			 	
			     if(statistiqueSearchDTO.getStartDate()!=null )
			     {
			    	querybuild2=querybuild2+"  createdOn BETWEEN CAST(:startDate AS DATE) AND  CAST((:endDate+ INTERVAL 1 DAY) AS DATE)";
			    	headQuery2=true;
			     }
			     logger.info("querybuild2 = "+querybuild2);
			     sqlQuery2 = session.createSQLQuery(querybuild2);
			     
			     
			    
	             if(statistiqueSearchDTO.getStartDate()!=null ) sqlQuery.setParameter("startDate", statistiqueSearchDTO.getStartDate());
			     if(statistiqueSearchDTO.getEndDate()!=null ) sqlQuery.setParameter("endDate", statistiqueSearchDTO.getEndDate());
			     List<BigInteger> rows = sqlQuery.list();
			     logger.info( "sizeresultfailProcess=" +rows.size());
			     for(BigInteger row : rows){
				    resultOfSearchCriterea.setNbFailProcess(row);
				    this.logger.info(  "result of nbFailProcess= " +resultOfSearchCriterea.getNbFailProcess());  
				    listResult.add(resultOfSearchCriterea);
			       }
			    
	             if(statistiqueSearchDTO.getStartDate()!=null ) sqlQuery2.setParameter("startDate", statistiqueSearchDTO.getStartDate());
			     if(statistiqueSearchDTO.getEndDate()!=null ) sqlQuery2.setParameter("endDate", statistiqueSearchDTO.getEndDate());
			     List<BigInteger> rowscompleted = sqlQuery2.list();
			     logger.info( "sizeresultTaskResult=" +rowscompleted.size());
			     for(BigInteger row : rowscompleted){
				    resultOfSearchCriterea.setNbTaskProcess(row);
				    this.logger.info(  "result of nbTaskProcess= " +resultOfSearchCriterea.getNbTaskProcess()); 
				  
			       } 
			      
			      finished = Boolean.valueOf(true);
			     session.getTransaction().commit();      
			   }
			   catch (Exception e)
			   {
			     e.printStackTrace();
			     throw e;
			   }
			   finally
			   {
			     if ((session != null) && (session.isOpen())) {
			       session.close();
			     }
			   }
			   
			   this.logger.info("<=SearchProcess out finished with : " + finished);    
			   return  listResult;
		 }
}