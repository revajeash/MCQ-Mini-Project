package com.student;

import java.sql.SQLException;
import java.util.Scanner;

import com.mainMenu.Menu;

public class Student {
	
	static Scanner scanner = new Scanner(System.in); // Scanner class object creation.

	public static void studentMainMenu() throws InterruptedException, SQLException {

		System.out.print("\nOpening Student Menu");

		for (int i = 0; i < 3; i++) {
			Thread.sleep(800);
			System.out.print(".");
		}

		System.out.println("\n\n<< Student Menu >>");
		System.out.println("1. Student Registration");
		System.out.println("2. Student Login");
		System.out.println("3. Forgot Password");
		System.out.println("4. Return to Main Menu");

		System.out.print("\nEnter your choice : ");

		int userChoice = scanner.nextInt();

		switch (userChoice) {

		case 1: StudentRegister.getStudentDetails(); // method calling
			break;
		case 2: StudentLogin.studentLogin1(); // method calling
			break;
		case 3: ForgotPwdStudent.studentVerify(); // method calling
			break;
		case 4: Menu.getMenu(); // method calling
			break;
			
		default: 
			System.out.println("Invalid Choice.\nReturning to Student Menu.");
			studentMainMenu(); // method calling
		}
	}

}
