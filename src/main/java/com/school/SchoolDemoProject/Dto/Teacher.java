package com.school.SchoolDemoProject.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tid;
	private String firstName;
	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;
	private String gender;
	private LocalDate dob;
	@Column(nullable = false, unique = true)
	private long phone;
	private String subject;
	@Column(nullable = false)
	private String password;
	private LocalDateTime lastLogin;

	public void updateEssentialDetails(Teacher teacher) {
		this.firstName = teacher.getFirstName();
		this.lastName = teacher.getLastName();
		this.gender = teacher.getGender();
		this.dob = teacher.getDob();
		this.phone = teacher.getPhone();
		this.subject = teacher.getSubject();
	}
	
	

	public Teacher() {
		super();
	}



	public Teacher(String firstName, String lastName, String email, String gender, LocalDate dob, long phone,
			String subject, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
		this.subject = subject;
		this.password = password;
	}



	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", dob=" + dob + ", phone=" + phone + ", subject=" + subject + ", password="
				+ password + ", lastLogin=" + lastLogin + "]\n";
	}

}
