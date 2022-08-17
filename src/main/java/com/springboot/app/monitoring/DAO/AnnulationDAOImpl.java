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

import com.springboot.app.monitoring.model.AnnulationDTO;
import com.springboot.app.monitoring.model.AnnulationSearchDTO;
import com.springboot.app.monitoring.model.DetailsTache;
import com.springboot.app.monitoring.model.ProcessDetails;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Transactional
@Repository
public class AnnulationDAOImpl implements AnnulationDAO {
	private SessionFactory sessionfactory;
	 org.slf4j.Logger logger = LoggerFactory.getLogger(AnnulationDAOImpl.class);
	 
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${requestAnnulation}")
	String requestAnnulation;
	@Value("${requestdetailsvariableprocess}")
	String requestdetailsvariableprocess;
	@Value("${requestSearchAnnulation}")
	String requestSearchAnnulation;
	@Value("${requestTachedetails}")
	String requestTachedetails;
	@Value("${requestUpdateStatus1}")
	String requestUpdateStatus1;
	//Search
		public AnnulationDAOImpl(SessionFactory sessionfactory) {
			this.sessionfactory = sessionfactory;
			}
		public   List<AnnulationDTO> SearchProcessEncours(AnnulationSearchDTO annulationSearchDTO){
			List<AnnulationDTO> listResult = new  ArrayList<AnnulationDTO>();
			AnnulationDTO annulationDTO = new AnnulationDTO();
			   
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery = null;  
			   logger.info("start_date="+annulationSearchDTO.getStart_date());
			   logger.info("end_date="+annulationSearchDTO.getEnd_date());
			   logger.info("processInstanceId="+annulationSearchDTO.getProcessInstanceId()); 
			   logger.info("processId="+annulationSearchDTO.getProcessId()); 
			   logger.info("value=" +annulationSearchDTO.getCo_id());
			   String query;
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
			 
			     
			   String querybuild=  requestSearchAnnulation;
			   boolean headQuery=false;
			 
			
			    querybuild=querybuild+" status = 1";
			    headQuery=true;
			   
			   
			   if(annulationSearchDTO.getProcessInstanceId()!=null)
			   {
				   if(headQuery)querybuild=querybuild+" AND";
			    querybuild=querybuild+" processInstanceId = :processInstanceId";
			    headQuery=true;
			   }
			  
			   if(annulationSearchDTO.getStart_date()!=null )
			   {
			    if(headQuery)querybuild=querybuild+" AND";
			    querybuild=querybuild+" start_date between  :start_date and :end_date";
			    headQuery=true;
			   }
			   if(annulationSearchDTO.getCo_id()!=null )
			   {
			    if(headQuery)querybuild=querybuild+" AND";
			    querybuild=querybuild+" processInstanceId in (select processInstanceId from jbpm.variableinstancelog where (variableId=upper('co_id') or variableId=upper('oldcoid') or variableId=upper('coid'))and value= :value)";
			    headQuery=true;
			   }
			    if(annulationSearchDTO.getProcessId()!=null)
			   {
			    	 if(headQuery)querybuild=querybuild+" AND";
			    querybuild=querybuild+" processId like concat(\"%\",:processId,\"%\")";
			    headQuery=true;
			   }
			   logger.info("querybuild = "+querybuild);
			     //With String Build		     
			       sqlQuery = session.createSQLQuery(querybuild);

			if(annulationSearchDTO.getStart_date()!=null )
				sqlQuery.setParameter("start_date", annulationSearchDTO.getStart_date());

			       if(annulationSearchDTO.getEnd_date()!=null ) 
			    	   sqlQuery.setParameter("end_date", annulationSearchDTO.getEnd_date());
			   	   
			       if(annulationSearchDTO.getProcessInstanceId()!=null )    
			    	   sqlQuery.setParameter("processInstanceId", annulationSearchDTO.getProcessInstanceId());
			       
			       if(annulationSearchDTO.getProcessId()!=null )    
			    	   sqlQuery.setParameter("processId", annulationSearchDTO.getProcessId());
			    if(annulationSearchDTO.getCo_id()!=null  )
			    	sqlQuery.setParameter("value", annulationSearchDTO.getCo_id());

			 
			       List<Object[]> rows = sqlQuery.list();
			       logger.info( "sizeresult=" +rows.size());
			       
			      for(Object[] row : rows){
			    	  annulationDTO = new AnnulationDTO();
			    	  if((annulationDTO.toString()!=null)||(String.valueOf(annulationDTO.getProcessInstanceId())!=null)){
			    	  annulationDTO.setProcessInstanceId((BigInteger) row[0]);
			       this.logger.info(  "result of ProcessInstanceId= " +annulationDTO.getProcessInstanceId());
			    	  }
			          
				       if((annulationDTO!=null)||(!annulationDTO.getProcessId().isEmpty())
				    		   
				    		      ||(annulationDTO.getProcessId()!=null)||(String.valueOf(annulationDTO.getProcessId())!=null)){
			       annulationDTO.setProcessId((String) row[1]);
			       this.logger.info(  "result of ProcessId= " +annulationDTO.getProcessId());
				       }
				       
			       annulationDTO.setStatus((int) row[2]);
			       this.logger.info(  "result of status= " + annulationDTO.getStatus());
			             
			       if((annulationDTO!=null)||(!annulationDTO.getStart_date().isEmpty())
			    		   
			    		      ||(annulationDTO.getStart_date()!=null)||(String.valueOf(annulationDTO.getStart_date())!=null)){


			    	   annulationDTO.setStart_date(row[3].toString());
			       this.logger.info(  "result of startDate= " +row[3].toString());
			       }
			     
			      
			       listResult.add(annulationDTO);        
			   }
			     finished = Boolean.valueOf(true);
			     session.getTransaction().commit();      
			     this.logger.info("select avec succees " + annulationSearchDTO.getProcessId() + "with " + finished);      
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
			   this.logger.info("resultSearchCriterea.getProcessId() = "+ annulationDTO.getProcessInstanceId());
			   this.logger.info("<=SearchProcess out finished with : " + finished);    
			   return listResult;
			} 
		
		
		
	//getAllProcessEncours
	@Override
	public   List<AnnulationDTO> getProcessEncours(AnnulationDTO annulationDTO){
		 logger.info("requestAnnulation="+requestAnnulation);
		return jdbcTemplate.query(requestAnnulation,
				new BeanPropertyRowMapper<AnnulationDTO>(AnnulationDTO.class));
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
	//updatestatus 
		 @Override
			public void updateByProcessInstanceId(BigInteger processInstanceId){ 		  
			String sql = requestUpdateStatus1; 
			 this.jdbcTemplate.update(
		                sql,processInstanceId);
			   }
}
