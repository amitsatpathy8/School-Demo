package com.school.SchoolDemoProject.backDoorEntry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.SchoolDemoProject.Dao.TeacherDao;
import com.school.SchoolDemoProject.Dto.Teacher;

/**
 * This class helps to insert teacher details
 * while the application is running. (This entire new teacher creation
 * is done over another thread). All of these are done on CLI
 * */
@Component
public class TeacherApplication {

	@Autowired
	private TeacherDao dao;

	public void teacherApp() {
		System.out.println("1. Teacher Signup");
		System.out.println("2. View Teacher Details By Email");
		System.out.println("3. Delete Teacher");
		try {
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			switch (option) {
			case 1: {
				/**
				 * This will create a teacher account
				 * */
				try {
					System.out.print("Enter Teacher First Name: ");
					String firstName = sc.next();
					System.out.print("Enter Teacher Last Name: ");
					String lastName = sc.next();
					System.out.print("Enter Teacher Gender: ");
					String gender = sc.next();
					System.out.print("Enter Teacher DOB(YYYY-MM-DD): ");
					String dobString = sc.next();
					LocalDate dob = LocalDate.parse(dobString);
					System.out.print("Enter Teacher Phone Number: ");
					long phone = sc.nextLong();
					System.out.print("Enter Teacher Email ID: ");
					String email = sc.next();
					System.out.print("Enter Teacher Subject: ");
					sc.nextLine();
					String subject = sc.nextLine();
					System.out.print("Enter Teacher Password: ");
					String password = sc.nextLine();

					Teacher teacher = new Teacher(firstName, lastName, email, gender, dob, phone, subject, password);
					if (dao.saveTeacher(teacher)) {
						System.out.println("New Teacher Created Successfully");
					} else {
						System.out.println("Somthing went wrong!");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 2: {
				/**
				 * This will display the teacher details
				 * by taking email as argument.
				 * */
				try {
					System.out.print("Enter Teacher Email ID: ");
					String email = sc.next();
					Teacher teacher = dao.getTeacherByEmail(email);
					if (teacher == null) {
						System.out.println("No teacher present with the email id : " + email);
					} else {
						System.out.println(teacher);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				/**
				 * This will delete a teacher
				 * by taking teacher id as argument.
				 * */
				try {
					System.out.print("Enter Teacher ID: ");
					int id = sc.nextInt();
					if (dao.deleteTeacher(id)) {
						System.out.println("Teacher deletion successfull");
					} else {
						System.out.println("Somthing went wrong please try again");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + option);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
