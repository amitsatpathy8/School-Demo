package com.school.SchoolDemoProject.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolDemoProject.IoModel.StudentDetails;
import com.school.SchoolDemoProject.utill.StudentDetailsUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Teacher {

	@Autowired
	private StudentDetailsUtil studentUtil;

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
		ModelAndView view = new ModelAndView("home");
		return view;
	}

	@RequestMapping("/addstudentdetails")
	public ModelAndView addStudentForm(HttpServletRequest request, HttpServletResponse response) {
		StudentDetails details = new StudentDetails();
		HttpSession session = request.getSession();
		session.setAttribute("invalidDetails", false);
		ModelAndView view = new ModelAndView("addstudent");
		view.addObject(details);
		return view;
	}

	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute StudentDetails details, HttpServletRequest request,
			HttpServletResponse response) {
		if (!studentUtil.isValidStudentDetails(details)) {
			HttpSession session = request.getSession();
			session.setAttribute("invalidDetails", true);
			ModelAndView view = new ModelAndView("addstudent");
			view.addObject(details);
			return view;
		}
		System.out.println(details);
		ModelAndView view = new ModelAndView("home");
		return view;
	}
}
