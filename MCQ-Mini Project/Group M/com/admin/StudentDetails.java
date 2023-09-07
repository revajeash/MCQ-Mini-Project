package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetails {

	static Scanner scanner = new Scanner(System.in);


	public static void getStudentData() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");

			// select query
			ps = con.prepareStatement("select *from student");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println();

				System.out.println("Student : " + rs.getInt(1));

				System.out.println("First Name : " + rs.getString(2));

				System.out.println("Last Name : " + rs.getString(3));

				System.out.println("Student-Id : " + rs.getString(4));

				System.out.println("Student-Password : " + rs.getString(5));

				System.out.println("Marks : " + rs.getInt(6));

				System.out.println("Grade : " + rs.getString(7));

				System.out.println();
				

			}
			
			System.out.print("Reruring Admin Sub Menu");
			
			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}
			System.out.println();
			
			AdminLogin.adminLogin2();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			con.close();
			ps.close();
		}
	}

}
