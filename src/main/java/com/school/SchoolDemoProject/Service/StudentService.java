package com.school.SchoolDemoProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolDemoProject.Dao.StudentDao;
import com.school.SchoolDemoProject.Dto.Student;
import com.school.SchoolDemoProject.IoModel.StudentDetails;
import com.school.SchoolDemoProject.utill.StudentDetailsUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;

	@Autowired
	private StudentDetailsUtil studentUtil;

	public ModelAndView getStudentForm(HttpServletRequest request, HttpServletResponse response) {
		StudentDetails details = new StudentDetails();
		HttpSession session = request.getSession();
		session.setAttribute("invalidDetails", false);
		ModelAndView view = new ModelAndView("addstudent");
		view.addObject(details);
		return view;
	}

	public ModelAndView saveStudent(StudentDetails details, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (!studentUtil.isValidStudentDetails(details)) {
			session.setAttribute("invalidDetails", true);
			session.setAttribute("error", "Invalid Details");
			ModelAndView view = new ModelAndView("addstudent");
			view.addObject(details);
			return view;
		}
		Student student = new Student(studentUtil.groomDetails(details));
		if (dao.saveStudent(student)) {
			ModelAndView view = new ModelAndView("home");
			return view;
		}
		session.setAttribute("invalidDetails", true);
		session.setAttribute("error", "Duplicate Entry");
		ModelAndView view = new ModelAndView("addstudent");
		view.addObject(details);
		return view;
	}

	public ModelAndView getHomePage(HttpServletRequest request, HttpServletResponse response) {
		List<Student> allStudets = dao.getAllStudets();
		HttpSession session = request.getSession();
		session.setAttribute("students", allStudets);
		ModelAndView view = new ModelAndView("home");
		return view;
	}

}
