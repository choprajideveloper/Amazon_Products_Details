package com.Connect_Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database_Connect {
	
	public static void DBConnect() {
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 String DB_URL="jdbc:mysql://localhost:3306/amazon_products";
			 String DB_USERID="root";
			 String DB_PASSWORD="root";
			 
			 Connection con = DriverManager.getConnection(DB_URL,DB_USERID,DB_PASSWORD);
			 
			 con.close();
			 
			 if(con.isClosed())
			 {
				 System.out.println("connection is closed");
			 }
			 else
			 {
				 System.out.println("connection is open");
			 } 
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}

