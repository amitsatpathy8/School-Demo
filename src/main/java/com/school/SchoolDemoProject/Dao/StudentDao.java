package com.school.SchoolDemoProject.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.SchoolDemoProject.Dto.Student;
import com.school.SchoolDemoProject.Repo.StudentRepo;

/**
 * Contains all methods to persist/retrieve/update/delete the Student data
 */

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo repo;

	public boolean saveStudent(Student student) {
		Student byEmail = repo.findByEmail(student.getEmail());
		if (byEmail == null) {
			repo.save(student);
			return true;
		}
		return false;
	}

	public List<Student> getAllStudets() {
		return repo.findAll();
	}

	public Student getDetails(int sid) {
		Optional<Student> findById = repo.findById(sid);
		return findById.isPresent() ? findById.get() : null;
	}

	public boolean updateDetails(Student student) {
		Student student2 = repo.findByEmail(student.getEmail());
		if (student2 == null)
			return false;
		student2.updateStudent(student);
		repo.save(student2);
		return true;
	}

	public boolean deleteStudent(int sid) {
		Optional<Student> findById = repo.findById(sid);
		if (findById.isPresent()) {
			repo.delete(findById.get());
			return true;
		}
		return false;
	}

	public List<Student> searchByName(String name) {
		return repo.searchByName(name);
	}

	public List<Student> searchByClass(String sclass) {
		return repo.searchByClass(sclass);
	}

	public List<Student> searchByEmail(String email) {
		return repo.searchByEmail(email);
	}

	public List<Student> searchByContact(long contact) {
		return repo.searchByContact(contact);
	}

	public List<Student> searchByGender(String gender) {
		return repo.searchByGender(gender);
	}

	public List<Student> searchByCity(String city) {
		return repo.searchByCity(city);
	}

	public List<Student> searchByState(String state) {
		return repo.searchByState(state);
	}

	public List<Student> searchByCountry(String country) {
		return repo.searchByCountry(country);
	}

}
