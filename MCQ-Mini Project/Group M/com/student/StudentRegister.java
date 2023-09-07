package com.student;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.storing.database.StudentDB;

public class StudentRegister {

	static Scanner scanner = new Scanner(System.in);

	public static void getStudentDetails() {

		try {

			System.out.print("\nEnter student first name:");

			String fName = scanner.next();

			System.out.print("Enter studentlast name:");

			String lName = scanner.next();

			boolean flag1 = ((fName != null) && (!fName.equals("")) && (fName.matches("^[a-zA-Z]*$")));

			boolean flag2 = ((lName != null) && (!lName.equals("")) && (lName.matches("^[a-zA-Z]*$")));
			;

			if (flag1 == true && flag2 == true) {

				validatePassword(fName, lName);

			} else {
				System.out.println("Invalid student details :\nEnter your details again.");

				getStudentDetails();
			}

		}

		catch (Exception e) {
			System.out.println("Invalid Input");
			getStudentDetails();
		}

	}

	public static void validatePassword(String studentFirstName, String studentLastName)
			throws InterruptedException, SQLException {

		String fName = studentFirstName;
		String lName = studentLastName;

		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

		System.out.print("\nEnter password:");

		String studentPassword = scanner.next();

		if (studentPassword.matches(pattern)) {

			Random random = new Random();

			String randomNumber = String.format("%04d", random.nextInt(10000));

			String studentId = studentLastName.concat(randomNumber);

			System.out.print("\nGenerating your student id for login");

			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}

			System.out.println("\n\nStudent Id : " + studentId);

			System.out.print("\nSubmitting your details please wait");

			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}
			
			int studentMarks = 0;
			String studentGrade = null;

			StudentDB.studentInfo(fName, lName, studentId, studentPassword, studentMarks, studentGrade);

			System.out.println("\n\nSuccessful Resistration.");

			System.out.print("\nReturning to Student Menu");
			for (int i = 0; i < 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}
			System.out.println("\n\n************************************************************************");
			Student.studentMainMenu();

		} else {
			System.out.println("Weak Password.");
			System.out.println("Enter your password again.");
			validatePassword(fName, lName);
		}

	}

}
