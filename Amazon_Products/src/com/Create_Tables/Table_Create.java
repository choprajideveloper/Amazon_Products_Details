package com.Create_Tables;

import java.sql.*;

public class Table_Create {

  public static void Create_Table()
  {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String DB_URL = "jdbc:mysql://localhost:3306/amazon_products";
			String DB_USERID = "root";
			String DB_PASSWORD = "root";

			Connection con = DriverManager.getConnection(DB_URL, DB_USERID, DB_PASSWORD);
			
			DatabaseMetaData dbm = con.getMetaData();
			// check if "employee" table is there
			ResultSet tables = dbm.getTables(null, null, "Products", null);
			if (tables.next()) {
			  System.out.println("Table already exists");
			  
			}
			else {
				
			String query1 = "create table Products(Product_Name  varchar(255) , Product_Price varchar(255))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query1);
			System.out.println("Table is created");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
