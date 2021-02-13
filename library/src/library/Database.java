package library;

import java.sql.*;
public class Database 
{
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/akash";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   Connection conn = null;
	   Statement stmt = null;
	   public void connect() 
	   {   
	      try 
	      {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
	      }
	      catch (ClassNotFoundException | SQLException e) 
	      {
	    	  e.printStackTrace();
	      }
	      
	   }
}