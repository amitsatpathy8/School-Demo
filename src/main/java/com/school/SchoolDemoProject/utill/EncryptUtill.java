package com.school.SchoolDemoProject.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptUtill {
	
	@Autowired
	private PasswordEncoderUtill encoderUtill;

	/**
	 * Created some utility method that help to
	 * encrypt and match the password.
	 */

	public String encryptPassword(String userpassword) {
		return encoderUtill.passwordEncoder().encode(userpassword);
	}

	public boolean match(String userpassword, String encryptedPassword) {
		PasswordEncoder encoder = encoderUtill.passwordEncoder();
		if (encoder.matches(userpassword, encryptedPassword)) {
			return true;
		} else {
			return false;
		}
	}
}
