package com.school.SchoolDemoProject.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolDemoProject.Dto.Student;
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

	@GetMapping("/home")
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

	@GetMapping("/studentdetails/{id}")
	public ModelAndView studentDetails(@PathVariable("id") int sid, HttpServletRequest request,
			HttpServletResponse response) {
		return studentService.allDetails(request, response, sid);
	}

	@GetMapping("/updatestudentform/{id}")
	public ModelAndView updateStudentForm(@PathVariable("id") int sid,HttpServletRequest request) {
		return studentService.updateForm(sid,request);
	}

	@PostMapping("/updatestudentform/update")
	public ModelAndView updateStudentDetails(@ModelAttribute Student student, HttpServletRequest request,
			HttpServletResponse response) {
		return studentService.updateDetails(student, request, response);
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int sid,HttpServletRequest request,
			HttpServletResponse response) {
		return studentService.deleteData(sid, request, response);
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("validated");
		ModelAndView view = new ModelAndView("index");
		return view;
	}

}
