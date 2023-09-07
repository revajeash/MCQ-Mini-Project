package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuestionsDetails {

	static Scanner scanner = new Scanner(System.in);


	public static void getQuizData() throws SQLException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");

			// select query
			ps = con.prepareStatement("select *from question");
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println();

				System.out.println("Question No : " + rs.getInt(1));

				System.out.println("Quetion : " + rs.getString(2));

				System.out.println("Option 1 : " + rs.getString(3));

				System.out.println("Option 2 : " + rs.getString(4));

				System.out.println("Option 3: " + rs.getString(5));

				System.out.println("Option 4 : " + rs.getString(6));

				System.out.println("Answer : " + rs.getString(7));

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
