package com.school.SchoolDemoProject.Dto;

import java.time.LocalDate;

import com.school.SchoolDemoProject.IoModel.StudentDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String firstName;
	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private long contact;
	private String gender;
	private String sclass;
	private String city;
	private String state;
	private String country;
	private LocalDate dob;

	public Student() {

	}

	public Student(StudentDetails details) {
		firstName = details.getFirstName();
		lastName = details.getLastName();
		email = details.getEmail();
		contact = details.getPhone();
		gender = details.getGender();
		sclass = details.getSclass();
		city = details.getCity();
		state = details.getState();
		country = details.getCountry();
		/**
		 * As because we are getting the data in the format of 2023-08-29
		 * so we don't need to use DateTimeFormatter
		 * */
		dob = LocalDate.parse(details.getDob());
	}

	/**
	 * All the getters and setters
	 */

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

}
