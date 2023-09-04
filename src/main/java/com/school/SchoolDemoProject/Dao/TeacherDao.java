package com.school.SchoolDemoProject.Dao;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.SchoolDemoProject.Dto.Teacher;
import com.school.SchoolDemoProject.Repo.TeacherRepo;
import com.school.SchoolDemoProject.utill.EncryptUtill;

/**
 * Contains all methods to
 * persist/retrieve/update/delete the Teacher data
 * */

@Repository
public class TeacherDao {
	@Autowired
	private TeacherRepo repo;
	
	@Autowired
	private EncryptUtill encryptUtill;
	
	/**
	 * The password is encoded in this area while sign up.
	 * */
	
	public boolean saveTeacher(Teacher teacher) {
		Teacher teacher2 = repo.findByEmail(teacher.getEmail());
		if (teacher2 == null) {
			String encodedPassword = encryptUtill.encryptPassword(teacher.getPassword());
			teacher.setPassword(encodedPassword);
			repo.save(teacher);
			return true;
		}
		return false;
	}

	public Teacher getTeacherDetails(int tid) {
		Optional<Teacher> findById = repo.findById(tid);
		return findById.isPresent() ? findById.get() : null;
	}
	
	public Teacher getTeacherByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public void trackLogin(String email,LocalDateTime dateTime) {
		Teacher teacher = repo.findByEmail(email);
		if(teacher!= null) {
			teacher.setLastLogin(dateTime);
			repo.save(teacher);
		}
	}
	
	public boolean updateDetails(Teacher teacher) {
		Optional<Teacher> findById = repo.findById(teacher.getTid());
		if(findById.isPresent()) {
			Teacher teacher2 = findById.get();
			teacher2.updateEssentialDetails(teacher);
			repo.save(teacher2);
			return true;
		}
		return false;
	}
	
	public boolean deleteTeacher(int tid) {
		Optional<Teacher> findById = repo.findById(tid);
		if(findById.isPresent()) {
			Teacher teacher2 = findById.get();
			repo.delete(teacher2);
			return true;
		}
		return false;
	}
}
