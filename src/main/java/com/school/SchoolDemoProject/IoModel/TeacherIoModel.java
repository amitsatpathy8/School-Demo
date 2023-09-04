package com.school.SchoolDemoProject.IoModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.school.SchoolDemoProject.Dto.Teacher;

public class TeacherIoModel {
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private LocalDate dob;
	private long phone;
	private String subject;
	private LocalDateTime lastLogin;
	
	public TeacherIoModel(Teacher teacher) {
		this.firstName = teacher.getFirstName();
		this.lastName = teacher.getLastName();
		this.email = teacher.getEmail();
		this.gender = teacher.getGender();
		this.dob = teacher.getDob();
		this.phone = teacher.getPhone();
		this.subject = teacher.getSubject();
		this.lastLogin = teacher.getLastLogin();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "TeacherIoModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", gender="
				+ gender + ", dob=" + dob + ", phone=" + phone + ", subject=" + subject + ", lastLogin=" + lastLogin
				+ "]";
	}

}
