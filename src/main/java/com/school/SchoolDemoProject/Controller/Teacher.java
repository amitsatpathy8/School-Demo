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
import com.school.SchoolDemoProject.Service.TeacherApplicationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * This contains all the routes for the application.
 * */

@Controller
public class Teacher {
	@Autowired
	private StudentService studentService;

	@Autowired
	private TeacherApplicationService teacherApplicationService;

	@RequestMapping("/loginValidation")
	public ModelAndView validate(@RequestParam String email, @RequestParam String pass, HttpServletRequest request,
			HttpServletResponse response) {
		return studentService.login(email, pass, request, response);
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
	public ModelAndView updateStudentForm(@PathVariable("id") int sid, HttpServletRequest request) {
		return studentService.updateForm(sid, request);
	}

	@PostMapping("/updatestudentform/update")
	public ModelAndView updateStudentDetails(@ModelAttribute Student student, HttpServletRequest request,
			HttpServletResponse response) {
		return studentService.updateDetails(student, request, response);
	}

	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int sid, HttpServletRequest request, HttpServletResponse response) {
		return studentService.deleteData(sid, request, response);
	}

	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("validated");
		ModelAndView view = new ModelAndView("index");
		return view;
	}
	
	@GetMapping("/searchForm")
	public ModelAndView seachForm() {
		return new ModelAndView("searchby");
	}
	
	@GetMapping("/result/{searchBy}/{keyword}")
	public ModelAndView search(@PathVariable String searchBy,@PathVariable String keyword,HttpServletRequest request, HttpServletResponse response) {
		return studentService.searchResult(searchBy, keyword, request, response);
	}
	
	/**
	 * This is the rout that helps
	 * to create a new thread for the CLI application
	 * to while request hit the URL. while the other user
	 *  can still use the application.
	 * */

	@RequestMapping("/maintain")
	public ModelAndView maintain() {
		return teacherApplicationService.runApp(teacherApplicationService);
	}

}
