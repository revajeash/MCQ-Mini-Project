package com.storing.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDB {

	public static void adminInfo(String fName, String lName, String adminId, String adminPassword) throws SQLException {

		//2nd Way : Inserting data into Database using "Prepare-Statement":--->
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// Step 1: loading the driver class:---> 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Establish the connection:---> 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");
			
			// Step 3: Prepare statement using Prepare SQL Statement:--->
			stmt =  con.prepareStatement("insert into admin(firstName, lastName, id, password) Values(?,?,?,?)");
			
			stmt.setString(1, fName);
			stmt.setString(2, lName);
			stmt.setString(3, adminId);
			stmt.setString(4, adminPassword);
			
			// Step 4:submit the SQL statement to database..
			int i=stmt.executeUpdate();
			System.out.println("Record is inserted:"+i);

		}catch(Exception e) {
			e.printStackTrace();
		}
		finally { 
			con.close(); // closed resources
			stmt.close();
		}

	}

}
