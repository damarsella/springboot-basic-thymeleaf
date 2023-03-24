package com.practice.controller;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MyController {
	
	// http://localhost:8080/about
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler...");
		
		//memasukkan data ke dalam model
		model.addAttribute("name", "Damar Sella");
		model.addAttribute("currentDate", new Date().toLocaleString());	
		
		//example
//		String nameString = "abc";
//		nameString.toUpperCase();
		
		return "about";
		//about.html
	}
	
	//handling iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model model) {
		//send
		
		//create a list, set colections
		
		List<String> names = List.of("Damar", "Sella", "Andre", "Ricky");
		
		model.addAttribute("names", names);
		
		return "iterate";
	}
	
	//handler for conditional statements
	@GetMapping("/condition")
	public String conditionalHandler(Model m) {
		System.out.println("conditional handler executed..");
		
		m.addAttribute("isActive", true);
		m.addAttribute("gender", "F");
		
		List<Integer> list = List.of();
		m.addAttribute("mylist", list);
		
		return "condition";
	}
	
	//handler for including fragments	
	@GetMapping("/service")
	public String servicesHandler(Model m) {
		
		m.addAttribute("title", "I like to eat samosa");
		m.addAttribute("subtitle", LocalDateTime.now().toString());
		
		//processing logic
		return "service";
	}
	
	//for new about
	@GetMapping("/newabout")
	public String newAbout() {	
		
		return "aboutnew";
	}
	
	@GetMapping("/contact")
	public String contact() {	
		
		return "contact";
	}	

}
