package com.school.SchoolDemoProject.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.SchoolDemoProject.Dto.Student;
import com.school.SchoolDemoProject.Repo.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo repo;
	
	public boolean saveStudent(Student student) {
		Student byEmail = repo.findByEmail(student.getEmail());
		if(byEmail == null) {
			repo.save(student);
			return true;
		}
		return false;
	}
	
	public List<Student> getAllStudets(){
		return repo.findAll();
	}
}