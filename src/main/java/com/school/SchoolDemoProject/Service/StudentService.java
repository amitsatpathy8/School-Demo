package com.school.SchoolDemoProject.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolDemoProject.Dao.StudentDao;
import com.school.SchoolDemoProject.Dao.TeacherDao;
import com.school.SchoolDemoProject.Dto.Student;
import com.school.SchoolDemoProject.Dto.Teacher;
import com.school.SchoolDemoProject.IoModel.StudentDetails;
import com.school.SchoolDemoProject.utill.EncryptUtill;
import com.school.SchoolDemoProject.utill.StudentDetailsUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

/**
 * It contains all the business login that requires
 * to process the data as well as 
 * produce the routes that can forwarded to the controller.
 * */

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;

	@Autowired
	private TeacherDao teacherDao;

	@Autowired
	private StudentDetailsUtil studentUtil;

	@Autowired
	private EncryptUtill passwordEncoder;
	
	/**
	 * Here we are validating the user of 
	 * the application using passwordEncoder
	 * */
	
	public ModelAndView login(String email, String pass, HttpServletRequest request, HttpServletResponse response) {
		Teacher teacher = teacherDao.getTeacherByEmail(email);
		if (teacher != null) {
			if (passwordEncoder.passwordEncoder().matches(pass, teacher.getPassword())) {
				teacherDao.trackLogin(email, LocalDateTime.now());
				try {
					HttpSession session = request.getSession();
					session.setAttribute("validated", true);
					response.sendRedirect("home");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		ModelAndView view = new ModelAndView("index");
		return view;
	}

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
			return getHomePage(request, response);
		}
		session.setAttribute("invalidDetails", true);
		session.setAttribute("error", "Duplicate Entry (Email)");
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

	public ModelAndView allDetails(HttpServletRequest request, HttpServletResponse response, int sid) {
		HttpSession session = request.getSession();
		session.setAttribute("alldetails", dao.getDetails(sid));
		ModelAndView view = new ModelAndView("fulldetails");
		return view;
	}

	public ModelAndView updateForm(int sid, HttpServletRequest request) {
		Student student = dao.getDetails(sid);
		HttpSession session = request.getSession();
		session.removeAttribute("invalidDetails");
		ModelAndView view = new ModelAndView("updatestudent");
		view.addObject(student);
		return view;
	}

	public ModelAndView updateDetails(Student student, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if (!studentUtil.isValidStudentDetails(new StudentDetails(student))) {
			session.setAttribute("invalidDetails", true);
			session.setAttribute("error", "Invalid Details");
			ModelAndView view = new ModelAndView("updatestudent");
			view.addObject(student);
			return view;
		}
		student = new Student(studentUtil.groomDetails(new StudentDetails(student)));
		if (dao.updateDetails(student)) {
			ModelAndView view = new ModelAndView("buffer");
			return view;
		}
		session.setAttribute("invalidDetails", true);
		session.setAttribute("error", "Duplicate Entry");
		ModelAndView view = new ModelAndView("updatestudent");
		view.addObject(student);
		return view;
	}

	public ModelAndView deleteData(int sid, HttpServletRequest request, HttpServletResponse response) {
		if (dao.deleteStudent(sid)) {
			return getHomePage(request, response);
		}
		return updateForm(sid, request);
	}

}
