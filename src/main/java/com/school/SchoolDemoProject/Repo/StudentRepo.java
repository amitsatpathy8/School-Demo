package com.school.SchoolDemoProject.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.SchoolDemoProject.Dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	public Student findByEmail(String email);
	
	@Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1% OR s.lastName LIKE %?1%")
	public List<Student> searchByName(String name);
	
	@Query("SELECT s FROM Student s WHERE s.sclass LIKE %?1%")
	public List<Student> searchByClass(String sclass);
	
	@Query("SELECT s FROM Student s WHERE s.email LIKE %?1%")
	public List<Student> searchByEmail(String email);
	
	@Query("SELECT s FROM Student s WHERE s.contact LIKE %?1%")
	public List<Student> searchByContact(long contanct);
	
	@Query("SELECT s FROM Student s WHERE s.gender LIKE %?1%")
	public List<Student> searchByGender(String gender);
	
	@Query("SELECT s FROM Student s WHERE s.city LIKE %?1%")
	public List<Student> searchByCity(String city);
	
	@Query("SELECT s FROM Student s WHERE s.state LIKE %?1%")
	public List<Student> searchByState(String state);
	
	@Query("SELECT s FROM Student s WHERE s.country LIKE %?1%")
	public List<Student> searchByCountry(String country);
	
}
