package com.dhananjay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;

import com.dhananjay.accessingdatamysql.Student;
import com.dhananjay.accessingdatamysql.StudentRepository;

import java.util.List;

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	
	@PostMapping("/studentdetails")
	public String greeting(@RequestParam(name = "stdid", required = true) Integer stdid,  Model model) {

		List<Student> studentlist= studentRepository.findAllByStdid(stdid);
        System.out.println("print the name:"+ studentlist.size());

		model.addAttribute("studentDetails", studentRepository.findAllByStdid(stdid));

		return "list-students";
		
	
}
	
	 
}