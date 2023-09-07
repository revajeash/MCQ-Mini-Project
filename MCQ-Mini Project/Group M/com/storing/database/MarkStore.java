package com.storing.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarkStore {

	public static void addMarksDB(String id,int score, String grade) throws SQLException {
		

		Connection con = null;
		PreparedStatement stmt = null;
		try {

			// Step 1: loading the driver class:--->
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Establish the connection:--->
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");

			// Step 3: Prepare statement using Prepare SQL Statement:--->
			stmt = con.prepareStatement("update student set Marks = ?, Grade = ? where id =?");

			stmt.setInt(1, score);
			stmt.setString(2, grade);
			stmt.setString(3, id);

			// Step 4:submit the SQL statement to database..
			stmt.executeUpdate();
			System.out.println("Marks stored successfully.");
			
			System.out.println("\n-------------------------------- Thank you -------------------------------- ");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close(); // closed resources
			stmt.close();
		}

	}

}
