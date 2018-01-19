package com.cts.pnrservice.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

public class DBConnectionManager {
	public DBConnectionManager() {
		
	}
	
	public  void closeConnection(Connection con) throws SQLException{
		if(con != null) {
			con.close();
		}
	}

	public static void closeResources(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException{
		if(rs != null) {
			rs.close();
		}
		
		if(ps != null) {
			ps.close();
		}
		
		if(con != null) {
			con.close();
		}
	}
	
	public static DBConnectionManager getInsatnce() {
		return new DBConnectionManager();
	}
	
	public  Connection getConnection()throws SQLException, Exception {
		Connection con = getDBConnection();
		return con;
	}
	
	private  Connection getDBConnection() throws SQLException, Exception{
		Connection con = null;
		
		try {
			//Properties prop = ApplicationPropertiesManager.getProperties("src/main/resources/DBConfig.properties");
			/*String host = "10.154.197.158";
			String port = "3306";
			String name = "testdb?useSSL=false";
			String username = "root";
			String password = "tibco123";
			System.out.println("1");
			String host = environment.getProperty("host");
			System.out.println("2");
			String port = environment.getProperty("port");
			String name = environment.getProperty("name");
			String username = environment.getProperty("username");
			String password = environment.getProperty("password");*/
			
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
	    	DBProperties appProperties = context.getBean(DBProperties.class);
	 
	       /* System.out.println("host-->"+appProperties.getHost());
	        System.out.println("name-->"+appProperties.getName());
	        System.out.println("port-->"+appProperties.getPort());
	        System.out.println("user name-->"+appProperties.getUsername());
	        System.out.println("password-->"+appProperties.getPassword());*/
		    
			/*String host = prop.getProperty("host");
			String port = prop.getProperty("port");
			String name = prop.getProperty("name");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");*/
	        
	        String host = appProperties.getHost();
			String port = appProperties.getPort();
			String name = appProperties.getName();
			String username = appProperties.getUsername();
			String password = appProperties.getPassword();
			
			String url = "jdbc:mysql://" + host + ":" + port + "/" + name;
			
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e){ 
			throw e;
		}
		return con; 
	}
	
}
