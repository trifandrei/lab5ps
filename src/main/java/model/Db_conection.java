package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class Db_conection {
 
	public Db_conection(){
		
	}
	
	public  Connection getConection() {
		
	 try {
		 String driver = "com.mysql.cj.jdbc.Driver";  
		 String url = "jdbc:mysql://localhost/bug_db";
		 String user = "root";
		 String pass = "omegaacer1";
		
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url,user,pass);
		return conn;
		
	 }catch(Exception e) {
		 System.out.println(e);
	 }	 
	
		return null;	
	}
	
	
}
