package com.school.SchoolDemoProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.SchoolDemoProject.Dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	public Student findByEmail(String email);
}
