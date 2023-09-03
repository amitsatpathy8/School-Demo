package com.school.SchoolDemoProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.SchoolDemoProject.Dto.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
	public Teacher findByEmail(String email);
}
