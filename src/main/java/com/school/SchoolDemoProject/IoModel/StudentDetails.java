package com.school.SchoolDemoProject.IoModel;

import com.school.SchoolDemoProject.Dto.Student;

/**
 * This class was only created to initially transfer the data
 * from the form to the server where some of the fields are String here
 * which help to validate the data easy. Also it contains
 * Constructor that can convert StudentDetails object to Student
 * */

public class StudentDetails {
	private String firstName;
	private String lastName;
	private String email;
	private long phone;
	private String sclass;
	private String gender;
	private String city;
	private String state;
	private String country;
	private String dob;

	public StudentDetails() {
		super();
	}
	
	/**
	 * Copy constructor
	 * */
	public StudentDetails(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.phone = student.getContact();
        this.sclass = student.getSclass();
        this.gender = student.getGender();
        this.city = student.getCity();
        this.state = student.getState();
        this.country = student.getCountry();
        this.dob = student.getDob().toString();
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "StudentDetails [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone="
				+ phone + ", sclass=" + sclass + ", gender=" + gender + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", dob=" + dob + "]\n";
	}
}
