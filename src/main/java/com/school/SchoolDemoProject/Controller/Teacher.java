package com.school.SchoolDemoProject.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolDemoProject.IoModel.StudentDetails;
import com.school.SchoolDemoProject.Service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Teacher {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/loginValidation")
	public ModelAndView validate(@RequestParam String email, @RequestParam String pass, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(email);
		System.out.println(pass);
		if (email.equals("admin@gmail.com") && pass.equals("admin")) {
			try {
				HttpSession session = request.getSession();
				session.setAttribute("validated", true);
				response.sendRedirect("home");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		return studentService.getHomePage(request, response);
	}

	@RequestMapping("/addstudentdetails")
	public ModelAndView addStudentForm(HttpServletRequest request, HttpServletResponse response) {
		return studentService.getStudentForm(request, response);
	}

	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute StudentDetails details, HttpServletRequest request,
			HttpServletResponse response) {
		return studentService.saveStudent(details, request, response);
	}
}
