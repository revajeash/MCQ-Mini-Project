package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class ForgotPwdAdmin {

	static Scanner scanner = new Scanner(System.in); // scanner class object creation.

	public static void adminVerify() throws SQLException {

		System.out.print("\nEnter your Admin Id : ");

		String admId = scanner.next();

		forgotPwdAdmin(admId); // method calling
	}

	public static void forgotPwdAdmin(String adminId) throws SQLException {

		String idAdmin = adminId;

		Connection con = null;
		PreparedStatement stmt = null;

		try {

			String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

			System.out.print("\nEnter your password : ");

			String adminNewPwd = scanner.next();

			if (adminNewPwd.matches(pattern)) {

				// Step 1: loading the driver class:--->
				Class.forName("com.mysql.cj.jdbc.Driver");

				// Step 2: Establish the connection:--->
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");

				// Step 3: Prepare statement using Prepare SQL Statement:--->
				stmt = con.prepareStatement("update admin set password = ? where id = ?");

				stmt.setString(1, adminNewPwd);
				stmt.setString(2, adminId);

				// Step 4:submit the SQL statement to database..
				stmt.executeUpdate();

				System.out.println("\nPassword Updated Successfully.");

				System.out.print("\nRetruning to admin menu");

				for (int i = 0; i < 3; i++) {
					Thread.sleep(800);
					System.out.print(".");
				}

				System.out.println("\n\n************************************************************************");

				Admin.adminMainMenu(); // method calling

			} else {

				System.out.println("\nEntered Password is weak.");

				forgotPwdAdmin(idAdmin); // method calling

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close(); // closed resources.
			stmt.close();
		}

	}

}
