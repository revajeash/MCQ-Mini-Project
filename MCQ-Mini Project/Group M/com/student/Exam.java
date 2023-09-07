package com.student;

import java.util.Scanner;

public class Exam {

	static Scanner scanner = new Scanner(System.in);

	public static void beforeExam(String id) throws InterruptedException {
		
		System.out.println("\n************************************************************************\n");

		System.out.println("\n------------------------- JAVA Quiz -------------------------");

		System.out.println("\nInstructions For Quiz :");

		System.out.println("1. This is quiz test has 10 questions.");

		System.out.println("2. Each question is of 1 marks so total 10 marks.");

		System.out.println("3. Multiple choice questions with only ONE valid answer.\n");

		selectOption(id);

	}

	public static void selectOption(String id) {

		try {

			System.out.println("Select Option: \n");

			System.out.println("1.Start Exam.\n2.Back to student menu.");

			System.out.print("\nEnter your option: ");

			int option = scanner.nextInt();
			
			System.out.println();

			switch (option) {

			case 1: StartExam.getQuestion(id);

				break;

			case 2: StudentLogin.studentLogin1();

				break;

			default:
				System.out.println("Invalid option.");
				selectOption(id);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
