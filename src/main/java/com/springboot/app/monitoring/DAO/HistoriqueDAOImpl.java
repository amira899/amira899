package com.springboot.app.monitoring.DAO;

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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.ResultSearchCriterea;
import com.springboot.app.monitoring.model.SearchCriterea;

import java.math.BigInteger;
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Transactional
@Repository
public class HistoriqueDAOImpl implements HistoriqueDAO{
	
	 private SessionFactory sessionfactory;
	 org.slf4j.Logger logger = LoggerFactory.getLogger(HistoriqueDAOImpl.class);
	 
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${requestTachedetails}")
	String requestTachedetails;
	@Value("${requestSearchCriterea}")
	String requestSearchCriterea;
	@Value("${requestselectall}")
	String requestselectall;
	@Value("${requestdetailsvariableprocess}")
	String requestdetailsvariableprocess;
	//Search
	public HistoriqueDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		}
		public List<ResultSearchCriterea> SearchProcess(SearchCriterea searchCriterea){
		   List<ResultSearchCriterea> listResult = new  ArrayList<ResultSearchCriterea>();
		   ResultSearchCriterea resultOfSearchCriterea = new ResultSearchCriterea();
		   Boolean finished = Boolean.valueOf(false);
		   Session session = null;
		   SQLQuery sqlQuery = null;  
		   logger.info("start_date="+searchCriterea.getStart_date());
		   logger.info("end_date="+searchCriterea.getEnd_date());
		   logger.info("statut="+searchCriterea.getStatus());
		   logger.info("processInstanceId="+searchCriterea.getProcessInstanceId()); 
		   logger.info("processId="+searchCriterea.getProcessId()); 
		   logger.info("value=" +searchCriterea.getCo_id());
		   String query;
		   try
		   {
		     session = this.sessionfactory.openSession();
		     session.beginTransaction();
		 
		   //check des objects null
		     
		     
		   //With String Build
		   String querybuild=  requestSearchCriterea;
		   boolean headQuery=false;
		   
		   if(searchCriterea.getProcessInstanceId()!=0)
		   {
			   if(headQuery)querybuild=querybuild+" AND";
		    querybuild=querybuild+" processInstanceId = :processInstanceId";
		    headQuery=true;
		   }
		  
		   if(searchCriterea.getStart_date()!=null )
		   {
		    if(headQuery)querybuild=querybuild+" AND";
		    querybuild=querybuild+" start_date between  :start_date and :end_date";
		    headQuery=true;
		   }
		   if(searchCriterea.getStatus()!=0 )
		   {
		    if(headQuery)querybuild=querybuild+" AND";
		    querybuild=querybuild+" status=:status";
		    headQuery=true;
		   }
		   if(searchCriterea.getCo_id()!=null )
		   {
		    if(headQuery)querybuild=querybuild+" AND";
		    querybuild=querybuild+" processInstanceId in (select processInstanceId from jbpm.variableinstancelog where (variableId=upper('co_id') or variableId=upper('oldcoid') or variableId=upper('coid'))and value= :value)";
		    headQuery=true;
		   }
		    if(searchCriterea.getProcessId()!=null)
		   {
		    querybuild=querybuild+" processId like concat(\"%\",:processId,\"%\") ";
		    headQuery=true;
		   }
		   logger.info("querybuild = "+querybuild);
		    
		       sqlQuery = session.createSQLQuery(querybuild);

		
		if(searchCriterea.getStart_date()!=null )
			sqlQuery.setParameter("start_date", searchCriterea.getStart_date());

		       if(searchCriterea.getEnd_date()!=null ) 
		    	   sqlQuery.setParameter("end_date", searchCriterea.getEnd_date());
		   
		   
		       if(searchCriterea.getProcessInstanceId()!=0 )    
		    	   sqlQuery.setParameter("processInstanceId", searchCriterea.getProcessInstanceId());
		       
		      if(searchCriterea.getProcessId()!=null )    
		    	   sqlQuery.setParameter("processId", searchCriterea.getProcessId());
		       
		       if(searchCriterea.getStatus()!=0 )    
		    	   sqlQuery.setParameter("status", searchCriterea.getStatus());

		    if(searchCriterea.getCo_id()!=null  )
		    	sqlQuery.setParameter("value", searchCriterea.getCo_id());

		 
		       List<Object[]> rows = sqlQuery.list();
		       logger.info( "sizeresult=" +rows.size());
		       
		      for(Object[] row : rows){
		       resultOfSearchCriterea = new ResultSearchCriterea();
		       if((resultOfSearchCriterea!=null)||
		    		   
		    (resultOfSearchCriterea.getProcessInstanceId()!=null)||(String.valueOf(resultOfSearchCriterea.getProcessInstanceId())!=null)){	
		       resultOfSearchCriterea.setProcessInstanceId((BigInteger) row[0]);
		       this.logger.info(  "result of ProcessInstanceId= " +resultOfSearchCriterea.getProcessInstanceId());
		       }
		       if((resultOfSearchCriterea!=null)||
		    		   
		   		    (resultOfSearchCriterea.getProcessId()!=null)||(String.valueOf(resultOfSearchCriterea.getProcessId())!=null)){	
		       resultOfSearchCriterea.setProcessId((String) row[1]);
		       this.logger.info(  "result of ProcessId= " +resultOfSearchCriterea.getProcessId());
		       }
		       if((resultOfSearchCriterea!=null)||
		    		   
			   		    (resultOfSearchCriterea.getStatus()!=0)||(String.valueOf(resultOfSearchCriterea.getStatus())!=null)){	
		       resultOfSearchCriterea.setStatus((int) row[2]);
		       this.logger.info(  "result of status= " +resultOfSearchCriterea.getStatus());
		 
		       }
		    		 if((resultOfSearchCriterea!=null)
		    		   
		    		      ||(resultOfSearchCriterea.getStart_date()!=null)||(String.valueOf(resultOfSearchCriterea.getStart_date())!=null)){	
		    			 resultOfSearchCriterea.setStart_date(row[3].toString()); 
		       this.logger.info(  "result of startDate= " +row[3].toString());
		       }
		    		 if(row[4]!=null) {
		       resultOfSearchCriterea.setEnd_date( row[4].toString());
		       this.logger.info(  "result of endDate= " +row[4].toString());
		    		   }
		       listResult.add(resultOfSearchCriterea);        
		   }
		     finished = Boolean.valueOf(true);
		     session.getTransaction().commit();      
		     this.logger.info("select avec succees " + searchCriterea.getProcessId() + "with " + finished);      
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
		   this.logger.info("resultSearchCriterea.getProcessId() = "+ resultOfSearchCriterea.getProcessInstanceId());
		   this.logger.info("<=SearchProcess out finished with : " + finished);    
		   return listResult;
		} 
         //get all process
		@Override
		public List<ResultSearchCriterea> getProcess(ResultSearchCriterea resultSearchCriterea){
			 logger.info("requestselectall="+requestselectall);
			return jdbcTemplate.query(requestselectall,
					new BeanPropertyRowMapper<ResultSearchCriterea>(ResultSearchCriterea.class));
			
		}	
		//get process details by processInstanceId
		 @Override
			public List<ProcessDetails> findByProcessInstanceId(long processInstanceId){ 		  
			String sql = requestdetailsvariableprocess; 
			try { 
				logger.info("exist");
		        return jdbcTemplate.query(sql, new Object[]{processInstanceId}, new BeanPropertyRowMapper<ProcessDetails>(ProcessDetails.class));
		        
			   }catch(Exception e) {
				   e.printStackTrace();
				   logger.info("exception not found " );			   
			return null;
			   }
			   }
		//get  details tache by processInstanceId
		 @Override
			public List<DetailsTache> getDetailsTache(long processInstanceId){ 		  
			String sql = requestTachedetails; 
			try { 
				logger.info("exist");
		        return jdbcTemplate.query(sql, new Object[]{processInstanceId}, new BeanPropertyRowMapper<DetailsTache>(DetailsTache.class));
		        
			   }catch(Exception e) {
				   e.printStackTrace();
				   logger.info("exception not found " );			   
			return null;
			   }
			   }
		    }	