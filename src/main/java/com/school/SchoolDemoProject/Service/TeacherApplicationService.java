package com.school.SchoolDemoProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.school.SchoolDemoProject.backDoorEntry.TeacherApplication;

/**
 * This class helps to generate new thread 
 * for the teacher "back door registration" through CLI as well as
 * produces a view when a request hit the URI.
 * We are achieving this by implementing the Runnable interface.
 * and to remove cyclic dependence we are passing 
 * this class object from the controller
 * */

@Service
public class TeacherApplicationService implements Runnable{
	@Autowired
	private TeacherApplication application;
	
	public ModelAndView runApp(TeacherApplicationService service) {
		Thread thread = new Thread(service);
		thread.start();
		ModelAndView view = new ModelAndView("showcase");
		return view;
	}

	@Override
	public void run() {
		System.out.println("On Track ---------->");
		application.teacherApp();
	}
}
