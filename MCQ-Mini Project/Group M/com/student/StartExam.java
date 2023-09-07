package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

import com.storing.database.MarkStore;

public class StartExam {

	static Scanner scanner = new Scanner(System.in);

	static Random random = new Random();

	public static void getQuestion(String id) throws SQLException {


		int marks = 0;

		ResultSet rs = null;
		Connection con = null;
		try {

			// step-1- Loading the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// step-2- Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz1?useSSL=false", "root", "root");

			// step-3
			PreparedStatement ps = con.prepareStatement("select * from question order by rand()");
			// step-4
			rs = ps.executeQuery();

			System.out.println("\n************************************************************************");
			

			System.out.print("\nStarting Exam");

			for (int i = 0; i <= 3; i++) {
				Thread.sleep(800);
				System.out.print(".");
			}
			System.out.println("\n");
			
			int i = 0;

			while (rs.next()) {
				
				i++;
				System.out.println(i);

				String question = rs.getString("quetions");
				System.out.println("Quetion: " + question);

				String option1 = rs.getString("option1");
				String option2 = rs.getString("option2");
				String option3 = rs.getString("option3");
				String option4 = rs.getString("option4");

				System.out.println("a : " + option1);
				System.out.println("b : " + option2);
				System.out.println("c : " + option3);
				System.out.println("d : " + option4);

				System.out.print("\nEnter Answer : ");
				String ans = scanner.next();
				System.out.println();

				if (ans.equals(rs.getString(7))) {
					marks++;

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			rs.close();
			con.close();
		}
		

		System.out.println("-------------------Result--------------------------");
		
		String grade = null;
	
		if (marks >= 8 && marks <= 10) {

			grade = " Class A";

		} else if (marks >= 6 && marks <= 8) {

			grade =" Class B";

		} else if (marks == 5) {

			grade = " Class C";

		} else {

			grade = " Class D-Fail";
		}
		
		System.out.println("Marks : " + marks + " / 10");
		
		System.out.println("Grade : " +grade);
		
		System.out.println();
		
		
		MarkStore.addMarksDB(id,marks, grade);
		
		
	}
}
