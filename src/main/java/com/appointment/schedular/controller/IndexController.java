package com.appointment.schedular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/**")
public class IndexController {
	
	@CrossOrigin
	@RequestMapping(value="home", method = RequestMethod.GET)
	public String getDashboardIndexPage() {
		return "home";
	}
	
	@CrossOrigin
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView  getDashboardSurveyPage() {
		ModelAndView model = new ModelAndView("index");
        return model;
	}
	
	@CrossOrigin
	@RequestMapping(value = "suggestion", method = RequestMethod.GET)
	public String getDashboardSuggestionPage() {
		return "index2";
	}
	
	@CrossOrigin
	@RequestMapping(value = "complaint", method = RequestMethod.GET)
	public String getDashboardComplaintPage() {
		return "complaint";
	}

}