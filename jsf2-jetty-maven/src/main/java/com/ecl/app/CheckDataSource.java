package com.ecl.app;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.EbeanServerFactory;
import com.avaje.ebean.SqlRow;
import com.avaje.ebean.config.DataSourceConfig;
import com.avaje.ebean.config.ServerConfig;
  
public class CheckDataSource {  
  
    public static void main(String[] args) {  
          
    	
//    	ServerConfig config = new ServerConfig();
//    	config.setName("pgtest");
//
//    	// Define DataSource parameters
//    	DataSourceConfig postgresDb = new DataSourceConfig();
//    	postgresDb.setDriver("org.postgresql.Driver");
//    	postgresDb.setUsername("postgres");
//    	postgresDb.setPassword("postgres");
//    	postgresDb.setUrl("jdbc:postgresql://127.0.0.1:5432/test");
//    	postgresDb.setHeartbeatSql("select count(*) from t_one");
//
//    	config.setDataSourceConfig(postgresDb);
//
//    	// specify a JNDI DataSource 
//    	// config.setDataSourceJndiName("someJndiDataSourceName");
//
//    	// set DDL options...
//    	config.setDdlGenerate(true);
//    	config.setDdlRun(true);
//
//    	config.setDefaultServer(false);
//    	config.setRegister(false);
//
//
//    	// automatically determine the DatabasePlatform
//    	// using the jdbc driver 
//    	// config.setDatabasePlatform(new PostgresPlatform());
//
//    	// specify the entity classes (and listeners etc)
//    	// ... if these are not specified Ebean will search
//    	// ... the classpath looking for entity classes.
//    	config.addClass(EBasicVer.class);
//    	
//
//    	// specify jars to search for entity beans
//    	config.addJar("someJarThatContainsEntityBeans.jar");
//
//    	// create the EbeanServer instance
//    	EbeanServer server = EbeanServerFactory.create(config);

    	
    	
    	
//        String sql = "select count(*) as count from contact";  
//        SqlRow row =   
//            Ebean.createSqlQuery(sql)  
//            .findUnique();  
//          
//        Integer i = row.getInteger("count");  
//          
//        System.out.println("Got "+i+"  - DataSource good.");  
    }  
}  