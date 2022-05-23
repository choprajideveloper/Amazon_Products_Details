package com.Products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertDataInTable {
	
	public static String InsertQuery = "insert into Products(Product_Name , Product_Price) values (?,?)";
	
	public static void InsertData(String product_name , String product_price) {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");

		String DB_URL = "jdbc:mysql://localhost:3306/amazon_products";
		String DB_USERID = "root";
		String DB_PASSWORD = "root";

		Connection con = DriverManager.getConnection(DB_URL, DB_USERID, DB_PASSWORD);

		PreparedStatement stmt = con.prepareStatement(InsertQuery);
		stmt.setString(1,product_name);
		stmt.setString(2,product_price);

		stmt.executeUpdate();
		System.out.println("Data is inserted");
		con.close();
	}

	catch (Exception e) {
		e.printStackTrace();
	  }
    
}
}
