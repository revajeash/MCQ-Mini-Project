package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentLogin {

	public static String studentUsername;

	static Scanner scanner = new Scanner(System.in);

	public static Connection getcon() {

		Connection con = null;
		try {

			// Step 1: loading the driver class:--->
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step 2: Establish the connection:--->
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1", "root", "aisha1604");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;

	}

	public static void studentLogin1() throws SQLException {

		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();

		Connection con = null;
		PreparedStatement stmt = null;
		try {

			con = getcon();

			stmt = con.prepareStatement("select username, password from student ");

			ResultSet rs = stmt.executeQuery();

			System.out.print("\nEnter Student Username : ");

			studentUsername = scanner.next();

			System.out.print("Enter your password : ");

			String studentpassword = scanner.next();

			while (rs.next()) {

				al1.add(rs.getString("username")); // All username get stored into our ArrayList object- al1

				al2.add(rs.getString("password")); // All password get stored into our ArrayList object- al2

			}

			if (al1.contains(studentUsername) && al2.contains(studentpassword)) {

				System.out.println("1. Go for Exam.");
				System.out.println("2. Return Student Menu.");
				studentLogin2(); // method calling

			} else {
				System.out.println("\nInvalid Student Username & Password.");

				studentLogin1(); // method calling
			}

		} catch (

		Exception e) {
			System.out.println(e);
		} finally {

			con.close(); // closed resources.
			stmt.close();
		}

	}

	public static void studentLogin2() {

		try {

			System.out.print("\nEnter your choice : ");

			int choice = scanner.nextInt();

			System.out.println();

			switch (choice) {


			case 1:
				Exam.beforeExam(studentUsername);
				break;

			case 2:
				Student.studentMainMenu();
				break;

			default:

				System.out.println("Invalid choice (Choice from - 1 / 2 ).");

				studentLogin2();

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	
	

}
