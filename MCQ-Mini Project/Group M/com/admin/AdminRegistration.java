package com.admin;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.storing.database.AdminDB;

public class AdminRegistration {

	static Scanner scanner = new Scanner(System.in); // Scanner class object creation

	public static void registerRulesAdmin() throws InterruptedException {

		System.out.println("\n************************************************************************");

		System.out.println("\n--------------- Welcome to Admin Registration Process ---------------");

		System.out.println("\nAdmin name & password must follow below criteria:");

		System.out.println("\n>>> Admin name contains <<<");

		System.out.println("-> Admin name should contain only characters.");

		System.out.println("-> Admin name should not contain any special characters.");

		System.out.println("\n>>> Password contains <<<");

		System.out.println("-> It doesn’t contain any white space.");

		System.out.println("-> At least one lowercase character (a-z)");

		System.out.println("-> At least one uppercase character (A-Z)");

		System.out.println("-> At least one digit (0-9)");

		System.out.println("-> At least one special character (? . , ! _ - ~ $ % + =)");

		getAdminDetails(); // method calling
	}

	public static void getAdminDetails() {

		try {

			System.out.print("\nEnter admin first name:");

			String fName = scanner.next();

			System.out.print("Enter admin last name:");

			String lName = scanner.next();

			boolean flag1 = ((fName != null) && (!fName.equals("")) && (fName.matches("^[a-zA-Z]*$")));

			boolean flag2 = ((lName != null) && (!lName.equals("")) && (lName.matches("^[a-zA-Z]*$")));
			;

			if (flag1 == true && flag2 == true) {

				validatePassword(fName, lName);

			} else {
				System.out.println("Invalid admin details :\nEnter your details again.");

				getAdminDetails();
			}

		}

		catch (Exception e) {
			System.out.println("Invalid Input");
			getAdminDetails();
		}
	}

	public static void validatePassword(String adminFirstName, String adminLastName) throws InterruptedException, SQLException {

		String fName = adminFirstName;
		String lName = adminLastName;

		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

		System.out.print("\nEnter password:");

		String adminPassword = scanner.next();

		if (adminPassword.matches(pattern)) {

			Random random = new Random();

			String randomNumber = String.format("%04d", random.nextInt(10000));

			String adminId = adminLastName.concat(randomNumber);

			System.out.print("\nGenerating your admin id for login");

			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}

			System.out.println("\n\nAdmin Id : " + adminId);

			System.out.print("\nSubmitting your details please wait");

			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}

			AdminDB.adminInfo(fName, lName, adminId, adminPassword);

			System.out.println("\n\nSuccessful Resistration.");

			System.out.print("\nReturning to Admin Menu");
			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}
			System.out.println("\n\n************************************************************************");
			Admin.adminMainMenu();

		} else {
			System.out.println("Weak Password.");
			System.out.println("Enter your password again.");
			validatePassword(fName, lName);
		}

	}
}
