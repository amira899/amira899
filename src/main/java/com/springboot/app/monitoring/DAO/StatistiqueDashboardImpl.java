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

import com.springboot.app.monitoring.model.ResultMoisStatistique;
import com.springboot.app.monitoring.model.StatistiqueTypeProcess;
import com.springboot.app.monitoring.model.StatistiqueUserIdentity;


@PropertySource(ignoreResourceNotFound = true, value = "classpath:application.properties")
@Transactional
@Repository
public class StatistiqueDashboardImpl implements StatistiqueDashboard {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Value("${requestMoisStatistique}")
	String requestMoisStatistique;
	@Value("${requestStatistiqueParStatut1}")
	String requestStatistiqueParStatut1;
	@Value("${requestStatistiqueParStatut2}")
	String requestStatistiqueParStatut2;
	@Value("${requestStatistiqueParStatut3}")
	String requestStatistiqueParStatut3;
	private SessionFactory sessionfactory;
	 org.slf4j.Logger logger = LoggerFactory.getLogger(StatistiqueDashboardImpl.class);
	public StatistiqueDashboardImpl(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
		}
		public List<ResultMoisStatistique> countNbProcessParMois(){
		 
			List<ResultMoisStatistique> listResult = new  ArrayList<ResultMoisStatistique>();
			ResultMoisStatistique resultOfNbProcess = new ResultMoisStatistique();
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery1 = null; 
			   SQLQuery sqlQuery2 = null;
			   SQLQuery sqlQuery3 = null;
			   SQLQuery sqlQuery4 = null;
			   SQLQuery sqlQuery5 = null;
			   SQLQuery sqlQuery6 = null;
			   SQLQuery sqlQuery7 = null;
			   SQLQuery sqlQuery8 = null;
			   SQLQuery sqlQuery9 = null;
			   SQLQuery sqlQuery10 = null;
			   SQLQuery sqlQuery11 = null;
			   SQLQuery sqlQuery12 = null;
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
				 String querybuild1=  requestMoisStatistique;
				 boolean headQuery1=false;
				 String querybuild2=  requestMoisStatistique;
			     boolean headQuery2=false;
			     String querybuild3=  requestMoisStatistique;
			     boolean headQuery3=false;
			     String querybuild4=  requestMoisStatistique;
			     boolean headQuery4=false;
			     String querybuild5=  requestMoisStatistique;
			     boolean headQuery5=false;
			     String querybuild6=  requestMoisStatistique;
			     boolean headQuery6=false;
			     String querybuild7=  requestMoisStatistique;
			     boolean headQuery7=false;
			     String querybuild8=  requestMoisStatistique;
			     boolean headQuery8=false;
			     String querybuild9=  requestMoisStatistique;
			     boolean headQuery9=false;
			     String querybuild10=  requestMoisStatistique;
			     boolean headQuery10=false;
			     String querybuild11=  requestMoisStatistique;
			     boolean headQuery11=false;
			     String querybuild12=  requestMoisStatistique;
			     boolean headQuery12=false;
			     
			     // nombre process en janvier
			    	querybuild1=querybuild1+" start_date like '%2022-01%'";
			    	 headQuery1=true;
			    
			     logger.info("querybuild1 = "+querybuild1);
			     sqlQuery1 = session.createSQLQuery(querybuild1);
			     
			     // nombre process en fivrier
			    	querybuild2=querybuild2+" start_date like '%2022-02%'";
			    	 headQuery2=true;
			    
			     logger.info("querybuild2 = "+querybuild2);
			     sqlQuery2 = session.createSQLQuery(querybuild2);
			     
			     // nombre process en Mars
			     querybuild3=querybuild3+" start_date like '%2022-03%'";
		    	 headQuery3=true;
		  
		     logger.info("querybuild3 = "+querybuild3);
		     sqlQuery3 = session.createSQLQuery(querybuild3);
              // nombre process en Avril
		     querybuild4=querybuild4+" start_date like '%2022-04%'";
	    	 headQuery4=true;
	  
	     logger.info("querybuild4 = "+querybuild4);
	     sqlQuery4 = session.createSQLQuery(querybuild4);
           // nombre process en May
	     querybuild5=querybuild5+" start_date like '%2022-05%'";
    	 headQuery5=true;
  
     logger.info("querybuild5 = "+querybuild5);
     sqlQuery5 = session.createSQLQuery(querybuild5);
          // nombre process en Juin
       
          querybuild6=querybuild6+" start_date like '%2022-06%'";
	       headQuery6=true;

         logger.info("querybuild6 = "+querybuild6);
          sqlQuery6 = session.createSQLQuery(querybuild6);
          
          //nombre process en Juillet
          querybuild7=querybuild7+" start_date like '%2022-07%'";
	       headQuery7=true;

           logger.info("querybuild7 = "+querybuild7);
           sqlQuery7 = session.createSQLQuery(querybuild7);
           
           //nombre process en Aout
           querybuild8=querybuild8+" start_date like '%2022-08%'";
 	       headQuery8=true;

            logger.info("querybuild8 = "+querybuild8);
            sqlQuery8 = session.createSQLQuery(querybuild8);
            
          //nombre process en Septembre
            querybuild9=querybuild9+" start_date like '%2022-09%'";
  	       headQuery9=true;

             logger.info("querybuild9 = "+querybuild9);
             sqlQuery9 = session.createSQLQuery(querybuild9);
             
           //nombre process en Octobre
             querybuild10=querybuild10+" start_date like '%2022-10%'";
   	       headQuery10=true;
   	       

              logger.info("querybuild10 = "+querybuild10);
              sqlQuery10 = session.createSQLQuery(querybuild10);
              
              //nombre process en Novembre
              querybuild11=querybuild11+" start_date like '%2022-11%'";
    	       headQuery11=true;
    	       

               logger.info("querybuild11 = "+querybuild11);
               sqlQuery11 = session.createSQLQuery(querybuild11);
               
               //nombre process en Decembre
               querybuild12=querybuild12+" start_date like '%2022-12%'";
     	       headQuery12=true;
     	       

                logger.info("querybuild12 = "+querybuild12);
                sqlQuery12 = session.createSQLQuery(querybuild12);
                
                
	            
			     List<BigInteger> rowsJanv = sqlQuery1.list();
			     logger.info( "sizeresult1=" +rowsJanv.size());
			     for(BigInteger row : rowsJanv){
			    	 resultOfNbProcess.setNbProcessJanv(row);
				    this.logger.info(  "result of processEnJanvier= " +resultOfNbProcess.getNbProcessJanv());  
				    listResult.add(resultOfNbProcess);
			       }
			    
	            //-----------------------------------------------------------------
			     List<BigInteger> rowsFiv = sqlQuery2.list();
			     logger.info( "sizeresult2=" +rowsFiv.size());
			     for(BigInteger row : rowsFiv){
			    	 resultOfNbProcess.setNbProcessFiv(row);
				    this.logger.info(  "result of processEnFivrier= " +resultOfNbProcess.getNbProcessFiv()); 
				    
			       } 
			     //---------------------------------------------------------------------
			   
			     List<BigInteger> rowsMars = sqlQuery3.list();
			     logger.info( "sizeresult3=" +rowsMars.size());
			     for(BigInteger row : rowsMars){
			    	 resultOfNbProcess.setNbProcessMars(row);
				    this.logger.info(  "result of processEnMars= " +resultOfNbProcess.getNbProcessMars()); 
				  
			       }
			     //-------------------------------------------------------------------------
			     List<BigInteger> rowsAvril = sqlQuery4.list();
			     logger.info( "sizeresult4=" +rowsAvril.size());
			     for(BigInteger row : rowsAvril){
			    	 resultOfNbProcess.setNbProcessAvril(row);
				    this.logger.info(  "result of processEnAvril= " +resultOfNbProcess.getNbProcessAvril()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsMay = sqlQuery5.list();
			     logger.info( "sizeresult5=" +rowsMay.size());
			     for(BigInteger row : rowsMay){
			    	 resultOfNbProcess.setNbProcessMay(row);
				    this.logger.info(  "result of processEnMay= " +resultOfNbProcess.getNbProcessMay()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsJuin = sqlQuery6.list();
			     logger.info( "sizeresult6=" +rowsJuin.size());
			     for(BigInteger row : rowsJuin){
			    	 resultOfNbProcess.setNbProcessJuin(row);
				    this.logger.info(  "result of processEnJuin= " +resultOfNbProcess.getNbProcessJuin()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsJuillet = sqlQuery7.list();
			     logger.info( "sizeresult7=" +rowsJuillet.size());
			     for(BigInteger row : rowsJuillet){
			    	 resultOfNbProcess.setNbProcessJuillet(row);
				    this.logger.info(  "result of processEnJuillet= " +resultOfNbProcess.getNbProcessJuillet()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsAout = sqlQuery8.list();
			     logger.info( "sizeresult8=" +rowsAout.size());
			     for(BigInteger row : rowsAout){
			    	 resultOfNbProcess.setNbProcessAout(row);
				    this.logger.info(  "result of processEnAout= " +resultOfNbProcess.getNbProcessAout()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsSept = sqlQuery9.list();
			     logger.info( "sizeresult9=" +rowsSept.size());
			     for(BigInteger row : rowsSept){
			    	 resultOfNbProcess.setNbProcessSept(row);
				    this.logger.info(  "result of processEnSeptembre= " +resultOfNbProcess.getNbProcessSept()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsOct = sqlQuery10.list();
			     logger.info( "sizeresult10=" +rowsOct.size());
			     for(BigInteger row : rowsOct){
			    	 resultOfNbProcess.setNbProcessOct(row);
				    this.logger.info(  "result of processEnOctobre= " +resultOfNbProcess.getNbProcessOct()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsNov = sqlQuery11.list();
			     logger.info( "sizeresult11=" +rowsNov.size());
			     for(BigInteger row : rowsNov){
			    	 resultOfNbProcess.setNbProcessNov(row);
				    this.logger.info(  "result of processEnNovembre= " +resultOfNbProcess.getNbProcessNov()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rowsDec = sqlQuery12.list();
			     logger.info( "sizeresult12=" +rowsDec.size());
			     for(BigInteger row : rowsDec){
			    	 resultOfNbProcess.setNbProcessDec(row);
				    this.logger.info(  "result of processEnDecembre= " +resultOfNbProcess.getNbProcessDec()); 
				  
			       }
			     //------------------------------------------------------
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
		// ---------------statistique nb process par type ---------------------
		
		public List<StatistiqueTypeProcess> countNbProcessType(){
			 
			List<StatistiqueTypeProcess> listResult2 = new  ArrayList<StatistiqueTypeProcess>();
			StatistiqueTypeProcess resultOfNbProcess = new StatistiqueTypeProcess();
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery1 = null; 
			   SQLQuery sqlQuery2 = null;
			   SQLQuery sqlQuery3 = null;
			   SQLQuery sqlQuery4 = null;
			   SQLQuery sqlQuery5 = null;
			   SQLQuery sqlQuery6 = null;
			   SQLQuery sqlQuery7 = null;
			   SQLQuery sqlQuery8 = null;
			  
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
				 String querybuild1=  requestMoisStatistique;
				 boolean headQuery1=false;
				 String querybuild2=  requestMoisStatistique;
			     boolean headQuery2=false;
			     String querybuild3=  requestMoisStatistique;
			     boolean headQuery3=false;
			     String querybuild4=  requestMoisStatistique;
			     boolean headQuery4=false;
			     String querybuild5=  requestMoisStatistique;
			     boolean headQuery5=false;
			     String querybuild6=  requestMoisStatistique;
			     boolean headQuery6=false;
			     String querybuild7=  requestMoisStatistique;
			     boolean headQuery7=false;
			     String querybuild8=  requestMoisStatistique;
			     boolean headQuery8=false;
	
			     
			     // nombre process Lte
			    	querybuild1=querybuild1+" processName ='StartParamLte'";
			    	 headQuery1=true;
			    
			     logger.info("querybuild1 = "+querybuild1);
			     sqlQuery1 = session.createSQLQuery(querybuild1);
			     
			     // nombre process Reengagement
			    	querybuild2=querybuild2+" processName ='MainReengagement'";
			    	 headQuery2=true;
			    
			     logger.info("querybuild2 = "+querybuild2);
			     sqlQuery2 = session.createSQLQuery(querybuild2);
			     
			     // nombre process migration intra
			     querybuild3=querybuild3+" processName ='MigrationIntra'";
		    	 headQuery3=true;
		  
		     logger.info("querybuild3 = "+querybuild3);
		     sqlQuery3 = session.createSQLQuery(querybuild3);
              // nombre process migration inter
		     querybuild4=querybuild4+" processName ='MigrationInter'";
	    	 headQuery4=true;
	  
	     logger.info("querybuild4 = "+querybuild4);
	     sqlQuery4 = session.createSQLQuery(querybuild4);
           // nombre process résiliation process
	     querybuild5=querybuild5+" processName ='ResiliationProcess'";
    	 headQuery5=true;
  
     logger.info("querybuild5 = "+querybuild5);
     sqlQuery5 = session.createSQLQuery(querybuild5);
          // nombre process Contract résiliation
       
          querybuild6=querybuild6+" processName ='ContractsResiliation'";
	       headQuery6=true;

         logger.info("querybuild6 = "+querybuild6);
          sqlQuery6 = session.createSQLQuery(querybuild6);
          
          //nombre process Picasso
          querybuild7=querybuild7+" processName ='remountPicassoWF'";
	       headQuery7=true;

           logger.info("querybuild7 = "+querybuild7);
           sqlQuery7 = session.createSQLQuery(querybuild7);
           
           //nombre process update option contract
           querybuild8=querybuild8+" processName ='UpdateOptionContract'";
 	       headQuery8=true;

            logger.info("querybuild8 = "+querybuild8);
            sqlQuery8 = session.createSQLQuery(querybuild8);
            
        
             
			     List<BigInteger> row1 = sqlQuery1.list();
			     logger.info( "sizeresult1=" +row1.size());
			     for(BigInteger row : row1){
			    	 resultOfNbProcess.setNbLte(row);
				    this.logger.info(  "result of processLte= " +resultOfNbProcess.getNbLte());  
				    listResult2.add(resultOfNbProcess);
			       }
			    
	            //-----------------------------------------------------------------
			     List<BigInteger> row2 = sqlQuery2.list();
			     logger.info( "sizeresult2=" +row2.size());
			     for(BigInteger row : row2){
			    	 resultOfNbProcess.setNbReengagement(row);
				    this.logger.info(  "result of processReengagement= " +resultOfNbProcess.getNbReengagement()); 
				    
			       } 
			     //---------------------------------------------------------------------
			   
			     List<BigInteger> rows3 = sqlQuery3.list();
			     logger.info( "sizeresult3=" +rows3.size());
			     for(BigInteger row : rows3){
			    	 resultOfNbProcess.setNbMigrationIntra(row);
				    this.logger.info(  "result of processMigrationIntra= " +resultOfNbProcess.getNbMigrationIntra()); 
				  
			       }
			     //-------------------------------------------------------------------------
			     List<BigInteger> rows4 = sqlQuery4.list();
			     logger.info( "sizeresult4=" +rows4.size());
			     for(BigInteger row : rows4){
			    	 resultOfNbProcess.setNbMigrationInter(row);
				    this.logger.info(  "result of processMigInter= " +resultOfNbProcess.getNbMigrationInter()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rows5 = sqlQuery5.list();
			     logger.info( "sizeresult5=" +rows5.size());
			     for(BigInteger row : rows5){
			    	 resultOfNbProcess.setNbResiliationP(row);
				    this.logger.info(  "result of processRésiliationProcess= " +resultOfNbProcess.getNbResiliationP()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rows6 = sqlQuery6.list();
			     logger.info( "sizeresult6=" +rows6.size());
			     for(BigInteger row : rows6){
			    	 resultOfNbProcess.setNbCoResiliation(row);
				    this.logger.info(  "result of processContractRésiliation= " +resultOfNbProcess.getNbCoResiliation()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rows7 = sqlQuery7.list();
			     logger.info( "sizeresult7=" +rows7.size());
			     for(BigInteger row : rows7){
			    	 resultOfNbProcess.setNbPicassoWF(row);
				    this.logger.info(  "result of processPicasso= " +resultOfNbProcess.getNbPicassoWF()); 
				  
			       }
			     //------------------------------------------------------
			     List<BigInteger> rows8 = sqlQuery8.list();
			     logger.info( "sizeresult8=" +rows8.size());
			     for(BigInteger row : rows8){
			    	 resultOfNbProcess.setNbUpdateOptionCo(row);
				    this.logger.info(  "result of processUpdateOptionContract= " +resultOfNbProcess.getNbUpdateOptionCo()); 
				  
			       }
			     //------------------------------------------------------
			    
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
			   return  listResult2;
		 }
		//------------Statistique  process started by user ----------------
		
		public List<StatistiqueUserIdentity> countNbProcessStartedByUser(){
			 
			List<StatistiqueUserIdentity> listResult3 = new  ArrayList<StatistiqueUserIdentity>();
			StatistiqueUserIdentity resultOfNbProcess = new StatistiqueUserIdentity();
			   Boolean finished = Boolean.valueOf(false);
			   Session session = null;
			   SQLQuery sqlQuery1 = null; 
			   SQLQuery sqlQuery2 = null;
			  
			   try
			   {
			     session = this.sessionfactory.openSession();
			     session.beginTransaction();
				 String querybuild1=  requestMoisStatistique;
				 boolean headQuery1=false;
				 String querybuild2=  requestMoisStatistique;
			     boolean headQuery2=false;
			    
	
			     
			     // nb process started by admin
			    	querybuild1=querybuild1+" user_identity ='admin'";
			    	 headQuery1=true;
			    
			     logger.info("querybuild1 = "+querybuild1);
			     sqlQuery1 = session.createSQLQuery(querybuild1);
			     
			     // nb process started by unknown
			    	querybuild2=querybuild2+" user_identity ='unknown'";
			    	 headQuery2=true;
			    
			     logger.info("querybuild2 = "+querybuild2);
			     sqlQuery2 = session.createSQLQuery(querybuild2);
			     
			    
			     List<BigInteger> row1 = sqlQuery1.list();
			     logger.info( "sizeresult1=" +row1.size());
			     for(BigInteger row : row1){
			    	 resultOfNbProcess.setProcessAdmin(row);
				    this.logger.info(  "result of processAdmin= " +resultOfNbProcess.getProcessAdmin());  
				    listResult3.add(resultOfNbProcess);
			       }
			    
	            //-----------------------------------------------------------------
			     List<BigInteger> row2 = sqlQuery2.list();
			     logger.info( "sizeresult2=" +row2.size());
			     for(BigInteger row : row2){
			    	 resultOfNbProcess.setProcessUnknown(row);
				    this.logger.info(  "result of processUnknown= " +resultOfNbProcess.getProcessUnknown()); 
				    
			       } 
			     //---------------------------------------------------------------------
			   
			     
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
			   return  listResult3;
		 }
		//---------get nb process en cours---------------
		 @Override
		 public int countNbProcessEncours(){ 		  
			String sql = requestStatistiqueParStatut1; 
			
		        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
		     
			   }
		//--------- get nb process Anuulée ---------------
		 @Override
		 public int countNbProcessAnnulee(){ 		  
			String sql = requestStatistiqueParStatut2; 
			
		        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
		     
			   }
		//--------- get nb process completée ---------------
		 @Override
		 public int countNbProcessCompletee(){ 		  
			String sql = requestStatistiqueParStatut3; 
			
		        return jdbcTemplate.queryForObject(sql, new Object[]{}, Integer.class);
		     
			   }
}