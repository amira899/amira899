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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.ResultTraceMail;
import com.springboot.app.monitoring.model.TraceMail;
@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Transactional
@Repository
public class TraceMailDAOImpl implements TraceMailDAO {
	 private SessionFactory sessionfactory;
	 org.slf4j.Logger logger = LoggerFactory.getLogger(TraceMailDAOImpl.class);
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${requestSearchTraceMail}")
	String requestSearchTraceMail;
	
	public TraceMailDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		}
		public List<ResultTraceMail> SearchTraceMail(TraceMail traceMail){
			  List<ResultTraceMail> listResult = new  ArrayList<ResultTraceMail>();
			  ResultTraceMail resultOfSearchCriterea = new ResultTraceMail();
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery = null;  
			   logger.info("adressMail="+traceMail.getAdressMail());
			   logger.info("receiver="+traceMail.getReceiver());
			   logger.info("send_date="+traceMail.getSend_date());
			   logger.info("end_date="+traceMail.getEnd_date());
			   String query;
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
			   String querybuild=  requestSearchTraceMail;
			   boolean headQuery=false;
			   
			   if(traceMail.getAdressMail()!=null)
			   {
				   
			    querybuild=querybuild+" adressMail =:adressMail";
			    headQuery=true;
			   }
			  
			   if(traceMail.getReceiver()!=null )
			   {
			    if(headQuery)querybuild=querybuild+" AND";
			    querybuild=querybuild+" receiver =:receiver";
			    headQuery=true;
			   }
			   if(traceMail.getSend_date()!=null )
			   {
			    if(headQuery)querybuild=querybuild+" AND";
			    querybuild=querybuild+"  send_date between  :send_date and :end_date";
			    headQuery=true;
			   }
		    
			   logger.info("querybuild = "+querybuild);
			   sqlQuery = session.createSQLQuery(querybuild);
			   if(traceMail.getAdressMail()!=null )
				sqlQuery.setParameter("adressMail", traceMail.getAdressMail());
			   if(traceMail.getReceiver()!=null ) 
			     sqlQuery.setParameter("receiver", traceMail.getReceiver());
			   if(traceMail.getSend_date()!=null )
					sqlQuery.setParameter("send_date", traceMail.getSend_date());

				       if(traceMail.getEnd_date()!=null ) 
				    	   sqlQuery.setParameter("end_date", traceMail.getEnd_date());

			       List<Object[]> rows = sqlQuery.list();
			       logger.info( "sizeresult=" +rows.size());
			       
			      for(Object[] row : rows){
			       resultOfSearchCriterea = new ResultTraceMail();
			       if((resultOfSearchCriterea!=null)|| (resultOfSearchCriterea.getAdressMail()!=null)||(String.valueOf(resultOfSearchCriterea.getAdressMail())!=null)){	
			       resultOfSearchCriterea.setAdressMail((String) row[0]);
			       this.logger.info(  "result of AdressMail= " +resultOfSearchCriterea.getAdressMail());
			       }
			       if((resultOfSearchCriterea!=null)||(resultOfSearchCriterea.getReceiver()!=null)||(String.valueOf(resultOfSearchCriterea.getReceiver())!=null)){	
			       resultOfSearchCriterea.setReceiver((String) row[1]);
			       this.logger.info(  "result of Receiver= " +resultOfSearchCriterea.getReceiver());
			       }
			       if((resultOfSearchCriterea!=null)||(resultOfSearchCriterea.getSend_date()!=null)||(String.valueOf(resultOfSearchCriterea.getSend_date())!=null)){	
				       resultOfSearchCriterea.setSend_date(row[2].toString());
				       this.logger.info(  "result of send date= " +row[2].toString());
				       }
			       listResult.add(resultOfSearchCriterea);        
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
			   return listResult;
			} 
}