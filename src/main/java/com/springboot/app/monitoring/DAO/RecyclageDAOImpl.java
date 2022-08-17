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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;
import com.springboot.app.monitoring.model.RecyclageDTO;
import com.springboot.app.monitoring.model.RecyclageSearchDTO;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Transactional
@Repository
public class RecyclageDAOImpl implements RecyclageDAO {
	private SessionFactory sessionfactory;
	 org.slf4j.Logger logger = LoggerFactory.getLogger(RecyclageDAOImpl.class);
	 
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${requestRecycleNumber}")
	String requestRecycleNumber;
	@Value("${requestTachedetails}")
	String requestTachedetails;
	@Value("${requestRecyclage}")
	String requestRecyclage;
	@Value("${requestSearchRecyclage}")
	String requestSearchRecyclage;
	@Value("${requestUpdateStatus}")
	String requestUpdateStatus;
	@Value("${requestdetailsvariableprocess}")
	String requestdetailsvariableprocess;
	//Search
			public RecyclageDAOImpl(SessionFactory sessionfactory) {
				this.sessionfactory = sessionfactory;
				}
			public   List<RecyclageDTO> SearchFailedProcess(RecyclageSearchDTO recyclageSearchDTO){
				List<RecyclageDTO> listResult = new  ArrayList<RecyclageDTO>();
				RecyclageDTO recyclageDTO = new RecyclageDTO();
				   
				   Boolean finished = Boolean.valueOf(false);
				   Session session = null;
				   SQLQuery sqlQuery = null;  
				   logger.info("start_date="+recyclageSearchDTO.getStart_date());
				   logger.info("end_date="+recyclageSearchDTO.getEnd_date());
				   logger.info("formName="+recyclageSearchDTO.getFormName()); 
				   logger.info("processInstanceId="+recyclageSearchDTO.getProcessInstanceId()); 
				   logger.info("value=" +recyclageSearchDTO.getCo_id());
				  
				   try
				   {
				     session = this.sessionfactory.openSession();
				     session.beginTransaction();
				 
				   //check des objects null
				     
				     
				     //With String Build
				     
				   String querybuild=  requestSearchRecyclage;
				   boolean headQuery=false;
				   
				    querybuild=querybuild+" status ='ready' ";
				    headQuery=true;
				    if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" processInstanceId in(select processInstanceId from jbpm.ProcessInstanceLog where status=1) ";
				    headQuery=true;
				    if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" upper(formName) like '%FAILURE%'";
				    headQuery=true;
				    if(recyclageSearchDTO.getStart_date()!=null )
				   {
				    if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" activationTime between  :start_date and :end_date";
				    headQuery=true;
				   }
				    if(recyclageSearchDTO.getProcessInstanceId()!=null)
				   {
				    	if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" processInstanceId=:processInstanceId or ProcessInstanceId in (select processInstanceId from jbpm.ProcessInstanceLog where parentProcessInstanceId=:processInstanceId) ";
				    headQuery=true;
				   }
				   if(recyclageSearchDTO.getFormName()!=null)
				   {
					   if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" formName=:formName ";
				    headQuery=true;
				   }
				  
				  
				   if(recyclageSearchDTO.getCo_id()!=null )
				   {
				    if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" processInstanceId in (select processInstanceId from jbpm.VariableInstanceLog  where (variableId=upper('co_id') or variableId=upper('coid')) and value=:value)";
				    headQuery=true;
				   }
				   
				   logger.info("querybuild = "+querybuild);
				     //With String Build		     
				       sqlQuery = session.createSQLQuery(querybuild);

				if(recyclageSearchDTO.getStart_date()!=null )
					sqlQuery.setParameter("start_date", recyclageSearchDTO.getStart_date());

				       if(recyclageSearchDTO.getEnd_date()!=null ) 
				    	   sqlQuery.setParameter("end_date", recyclageSearchDTO.getEnd_date());
				   	   
				       if(recyclageSearchDTO.getProcessInstanceId()!=null )    
				    	   sqlQuery.setParameter("processInstanceId", recyclageSearchDTO.getProcessInstanceId());
				       
				       if(recyclageSearchDTO.getFormName()!=null )    
				    	   sqlQuery.setParameter("formName", recyclageSearchDTO.getFormName());
				    if(recyclageSearchDTO.getCo_id()!=null  )
				    	sqlQuery.setParameter("value", recyclageSearchDTO.getCo_id());
			
				       List<Object[]> rows = sqlQuery.list();
				       logger.info( "sizeresult=" +rows.size());
				       
				      for(Object[] row : rows){
				    	  recyclageDTO = new RecyclageDTO();
				    	  if((recyclageDTO.getId()!=null)||(String.valueOf(recyclageDTO.getId())!=null)){
				    		  recyclageDTO.setId((BigInteger) row[0]);
				       this.logger.info(  "result of Id= " +recyclageDTO.getId());
				    	  }
				      if ((recyclageDTO.getFormName()!=null)||(String.valueOf(recyclageDTO.getFormName())!=null)){
					    	   recyclageDTO.setFormName((String) row[1]);
				       this.logger.info(  "result of formName= " +recyclageDTO.getFormName());
					       } 
				      if((recyclageDTO.getProcessInstanceId()!=null)||(String.valueOf(recyclageDTO.getProcessInstanceId())!=null)){
				    		  recyclageDTO.setProcessInstanceId((BigInteger) row[2]);
					       this.logger.info(  "result of ProcessInstanceId= " +recyclageDTO.getProcessInstanceId());
				       } 
				      
				    	  if((recyclageDTO!=null)||(String.valueOf(recyclageDTO.getProcessId())!=null)){
				    		  recyclageDTO.setProcessId((String) row[3]);
				       this.logger.info(  "result of ProcessId= " +recyclageDTO.getProcessId());
				    	  }

					       if ((recyclageDTO.getStatus()!=null)||(String.valueOf(recyclageDTO.getStatus())!=null)){
					       recyclageDTO.setStatus((String) row[4]);
				       this.logger.info(  "result of status= " + recyclageDTO.getStatus());
					       }
				       if((recyclageDTO!=null)||(!recyclageDTO.getActivationTime().isEmpty())
				    		   
				    		      ||(recyclageDTO.getActivationTime()!=null)||(String.valueOf(recyclageDTO.getActivationTime())!=null)){


				    	   recyclageDTO.setActivationTime(row[5].toString());
				       this.logger.info(  "result of activationTime= " +row[5].toString());
				       }
				      
				       listResult.add(recyclageDTO);        
				   }
				     finished = Boolean.valueOf(true);
				     session.getTransaction().commit();      
				     this.logger.info("select avec succees " + recyclageSearchDTO.getFormName() + "with " + finished);      
				   
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
				   return listResult;
				
				   }
			
// getallFailedProcess
	@Override
	public List<RecyclageDTO> getFailedProcess(RecyclageDTO recyclageDTO) {
		 logger.info("requestRecyclage="+requestRecyclage);
			return jdbcTemplate.query(requestRecyclage,
					new BeanPropertyRowMapper<RecyclageDTO>(RecyclageDTO.class));
		}
//updatestatus 
	 @Override
		public void updateByProcessInstanceId(BigInteger processInstanceId){ 		  
		String sql = requestUpdateStatus; 
		 this.jdbcTemplate.update(
	                sql,processInstanceId);
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
		//count nombre de recyclage de chaque process
		 @Override
		 public int countNombreRecyclage(long processInstanceId){ 		  
			String sql = requestRecycleNumber; 
			
		        return jdbcTemplate.queryForObject(sql, new Object[]{processInstanceId}, Integer.class);
		     
			   }	 
}