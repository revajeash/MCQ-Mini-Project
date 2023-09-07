package com.mainMenu;

import java.util.Scanner;

import com.admin.Admin;
import com.exit.Exit;
import com.student.Student;

public class Menu {

	static Scanner scanner = new Scanner(System.in); // Scanner class object creation.

	public static void getMenu() {

		int userChoice;

		try {

			System.out.println("\n<< Quiz Main Menu >>");
			System.out.println("1. Admin");
			System.out.println("2. Student");
			System.out.println("3. Exit");

			System.out.print("\nEnter your choice : ");

			userChoice = scanner.nextInt();

			switch (userChoice) {

			case 1:
				Admin.adminMainMenu(); // method calling
				break;

			case 2:
				Student.studentMainMenu(); // method calling
				break;

			case 3:
				Exit.exitQuiz(); // method calling
				break;

			default:
				System.out.println("Invalid choice.\nReturning to Quiz Main Menu.");
				getMenu(); // method calling
			}

		} catch (Exception e) {
			
			System.out.println("Invalid Choice.\nReturning to Quiz Main Menu.");
			getMenu(); // method calling
		}

	}

}
