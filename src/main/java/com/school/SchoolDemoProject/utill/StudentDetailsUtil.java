package com.school.SchoolDemoProject.utill;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.school.SchoolDemoProject.IoModel.StudentDetails;

@Component
public class StudentDetailsUtil {

	public StudentDetails groomDetails(StudentDetails details) {
		details.setFirstName(details.getFirstName().toLowerCase().trim());
		details.setLastName(details.getLastName().toLowerCase().trim());
		details.setEmail(details.getEmail().toLowerCase().trim());
		details.setCity(details.getCity().toLowerCase().trim());
		details.setState(details.getState().toLowerCase().trim());
		details.setCountry(details.getCountry().toLowerCase().trim());
		return details;
	}

	public boolean isValidStudentDetails(StudentDetails details) {
		if (isSafeToOperate(details)) {
			boolean status = true;
			if (!isValidString(details.getFirstName()))
				status = false;
			if (!isValidString(details.getLastName()))
				status = false;
			if (String.valueOf(details.getPhone()).length() != 10)
				status = false;
			/**
			 * Format that we receive from the form : yyyy-mm-d
			 */
			LocalDate dob = LocalDate.parse(details.getDob());
			LocalDate currentDate = LocalDate.now();
			Period difference = Period.between(dob, currentDate);
			if (difference.getYears() < 5) {
				status = false;
			}
			
			if(details.getSclass().equals("none")) {
				status = false;
			}
			return status;
		} else {
			return false;
		}
	}

	private boolean isValidString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 32 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96)
					|| (str.charAt(i) >= 123 && str.charAt(i) <= 126)) {
				return false;
			}
		}
		return true;
	}

	private boolean isSafeToOperate(StudentDetails details) {
		boolean status = true;
		if (details.getFirstName() == null)
			return false;
		if (details.getLastName() == null)
			return false;
		if (details.getEmail() == null)
			return false;
		if (details.getSclass() == null)
			return false;
		if (details.getState() == null)
			return false;
		if (details.getCity() == null)
			return false;
		if (details.getCountry() == null)
			return false;
		if (details.getDob() == null)
			return false;

		return status;
	}
}
