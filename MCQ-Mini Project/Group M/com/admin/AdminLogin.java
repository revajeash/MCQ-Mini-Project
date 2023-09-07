package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class AdminLogin {

	static Scanner scanner = new Scanner(System.in); // Scanner class object creation.

	public static Connection getConnection1() {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			// Step 1: loading the driver class:--->
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Step 2: Establish the connection:--->
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");

		} catch (Exception e) {

			e.printStackTrace();

		}
		return con;

	}

	public static void adminLogin1() throws SQLException {

		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();

		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = getConnection1(); // method calling
			
			// Step 3: Prepare the SQL statement:--->
			
			stmt = con.prepareStatement("select id, password from admin ");
			
			// Step 4:submit the SQL statement to database..
			
			ResultSet rs = stmt.executeQuery();

			System.out.print("\nEnter admin id : ");

			String adminId = scanner.next();

			System.out.print("Enter your password : ");

			String password = scanner.next();

			while (rs.next()) {

				al1.add(rs.getString("id"));  // All id get stored into our ArrayList object- al1

				al2.add(rs.getString("password")); // All password get stored into our ArrayList object- al2

			}

			if (al1.contains(adminId) && al2.contains(password)) {
				

				adminLogin2(); // method calling
				
			} else {
				System.out.println("\nInvalid admin id & password.");

				adminLogin1(); // method calling
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			con.close();  // closed resources.
			stmt.close();
		}

	}
	
	public static void adminLogin2() throws SQLException, InterruptedException {
		
		System.out.println("\n--------------------------- Admin Sub Menu --------------------------- ");
		
		System.out.println("\n1. Check all students records.");
		System.out.println("2. Display all questions.");
		System.out.println("3. Return to admin main menu");
		
		adminLogin3(); // method calling
	}

	public static void adminLogin3() throws SQLException, InterruptedException {
		

		System.out.print("\nEnter your choice : ");

		int choice = scanner.nextInt();

		switch (choice) {

		case 1: StudentDetails.getStudentData(); // method calling
			break;
			
		case 2: QuestionsDetails.getQuizData(); // method calling
			break;
			
		case 3: Admin.adminMainMenu(); // method calling
			break;
			
		default:
			System.out.println("\nInvalid choice.\nEnter choice (1/2/3).");
			adminLogin2(); // method calling

		}

	}

}
