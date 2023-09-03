package com.school.SchoolDemoProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaticViewResolver {
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

}
