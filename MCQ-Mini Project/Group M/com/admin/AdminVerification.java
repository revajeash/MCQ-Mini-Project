package com.admin;

import java.util.Scanner;


public class AdminVerification {

	private static final String adminKey = "java@2022"; // new admin can register using this adminKey only (i.e Secret Key)

	static Scanner scanner = new Scanner(System.in); // Scanner class object creation.

	public static void verifyAdmin() {

		try {

			System.out.print("\nEnter admin secrect key : ");

			String secretKey = scanner.next();

			if (secretKey.equals(adminKey)) {

				System.out.print("\nOpening Admin Registration");

				for (int i = 0; i < 3; i++) {
					Thread.sleep(800);
					System.out.print(".");
				}

				System.out.println();

				AdminRegistration.registerRulesAdmin();

			} else {
				System.out.println("\nInvalid Admin Secret Key...!");

				verifyAdmin(); // method calling
			}

		} catch (Exception e) {
			System.out.println("Invalid Choice");
		}

	}

}
