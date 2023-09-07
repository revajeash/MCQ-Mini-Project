package com.admin;

import java.sql.SQLException;
import java.util.Scanner;

import com.mainMenu.Menu;

public class Admin {

	static Scanner scanner = new Scanner(System.in); // Scanner class object creation.

	public static void adminMainMenu() throws InterruptedException, SQLException {

		System.out.print("\nOpening Admin Menu");

		for (int i = 0; i < 3; i++) { 
			Thread.sleep(800); // used sleep method of Thread class.
			System.out.print(".");
		}

		System.out.println("\n\n<< Admin Menu >>");
		System.out.println("1. Admin Registration");
		System.out.println("2. Admin Login");
		System.out.println("3. Forgot Password");
		System.out.println("4. Return to Main Menu");

		System.out.print("\nEnter your choice : ");

		int userChoice = scanner.nextInt();

		switch (userChoice) {

		case 1:
			AdminVerification.verifyAdmin(); // method calling
			break;
		case 2:
			AdminLogin.adminLogin1(); // method calling
			break;
		case 3:
			ForgotPwdAdmin.adminVerify(); // method calling
			break;
		case 4:
			Menu.getMenu(); // method calling
			break;
		default:
			System.out.println("Invalid choice.\nReturning to Admin Menu.");
			adminMainMenu(); // method calling

		}
	}

}
