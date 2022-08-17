package com.springboot.app.monitoring.DAO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.monitoring.model.CheckPasswordDTO;
import com.springboot.app.monitoring.model.User;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Repository
public class UserDAOImpl implements UserDAO {
  org.slf4j.Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
  private SessionFactory sessionfactory;
	@Autowired
	JdbcTemplate jdbcTemplate;
	//get all users
	@Value("${query2}")
	   private String query2;
	@Value("${query1}")
	   private String query1;
	@Value("${requestSelectPassword}")
	   private String requestSelectPassword;
	@Value("${requestUpdatePassword}")
	   private String requestUpdatePassword;
	public UserDAOImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		}
	@Override
	public List<User> findAllusers(){
		 logger.info("query1="+query1);
		return jdbcTemplate.query(query1,
				new BeanPropertyRowMapper<User>(User.class));
	}
	@Override
	public List<User> CheckPassword(CheckPasswordDTO checkPasswordDTO) {
		  Boolean finished = Boolean.valueOf(false);
		   Session session = null;
		   SQLQuery sqlQuery = null;  
		   List<User> listResult = new ArrayList<User>();
			User userr = new User();
		   try
		   {
		     session = this.sessionfactory.openSession();
		     session.beginTransaction();
			    logger.info("requestSelectPassword = "+requestSelectPassword);
		     String querybuild=  requestSelectPassword;
		     boolean headQuery=false;
			 
			
			    querybuild=querybuild+" password=:password";
			    headQuery=true;
			    
			    if(checkPasswordDTO.getIduser()!=0)
				   {
					   if(headQuery)querybuild=querybuild+" AND";
				    querybuild=querybuild+" iduser=:iduser";
				    headQuery=true;
				   }
			    logger.info("querybuild = "+querybuild);
			   		     
			       sqlQuery = session.createSQLQuery(querybuild);
				    logger.info("sqlQuery = "+sqlQuery);
			if(checkPasswordDTO.getPassword()!=null )sqlQuery.setParameter("password", checkPasswordDTO.getPassword());
			if(checkPasswordDTO.getIduser()!=0 )sqlQuery.setParameter("iduser", checkPasswordDTO.getIduser());
			logger.info("checkPasswordDTO.getIduser() = "+checkPasswordDTO.getIduser());
			logger.info("checkPasswordDTO.getPassword() = "+checkPasswordDTO.getPassword());
			/*if((checkPasswordDTO.getIduser()==userr.getIduser())&&(checkPasswordDTO.getPassword()==userr.getPassword())){
				 System.out.println(userr.getIduser());
		    	 System.out.println(userr.getPassword());
				 System.out.println("Username and Password exist"); 
			}else {
				System.out.println("Username and Password n'exist pas"); 
				 System.out.println(userr.getIduser());
		    	 System.out.println(userr.getPassword());
			}*/
			
			
			 List<BigInteger> rows = sqlQuery.list();
		       logger.info( "sizeresult=" +rows.size());
		       
		      for(BigInteger row : rows){
		    	  userr = new User();
		    	//  if((userr!=null)||((userr.getIduser())!=0)){
		    		  userr.setIduser(Long.valueOf(row.toString()) );
		    		  userr.setPassword((row.toString()) );

		    		  if((checkPasswordDTO.getIduser() == userr.getIduser() ) && (checkPasswordDTO.getPassword() == userr.getPassword())) {
		    			  System.out.println("password existe");
		    			  System.out.println(userr.getIduser());
		 		    	 System.out.println(userr.getPassword());
		    		  }else {
		    			  System.out.println("password n'existe pas!!!");
		    			  System.out.println(userr.getIduser());
		 		    	 System.out.println(userr.getPassword());
		    		  };
		    	  listResult.add(userr);        
			   }
			     finished = Boolean.valueOf(true);
			     session.getTransaction().commit();      
		   }catch (Exception e)
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
	@Override
	public void ChangePassword(String password, long id){
		try {
			String sql2 = requestUpdatePassword; 
			 this.jdbcTemplate.update(
		                sql2,password);
			   logger.info("password updated succefully " );
		   }catch(Exception e) {
			   e.printStackTrace();
			   logger.info("exception not found " );
		   }
	}
	    
   @Override
	public User findById(Long iduser) { 
	  
	String sql = query2; 
	try { 
		logger.info("exist " );
        return jdbcTemplate.queryForObject(sql, new Object[]{iduser}, new BeanPropertyRowMapper<User>(User.class));
	   }catch(Exception e) {
		   e.printStackTrace();
		   logger.info("exception not found " );
	   
	return null;
	   }
   }
    }