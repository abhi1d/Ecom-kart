package com.yodlee.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yodlee.entity.Student;

@RestController
@RequestMapping("/api")
public class TestRestController {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		List<Student> theStudent = new ArrayList<>();
		theStudent.add(new Student("abhishek","sharma"));
		theStudent.add(new Student("jaya","A K"));
		theStudent.add(new Student("rohit","kumawat"));
		theStudent.add(new Student("ankit","kumar"));
		return theStudent;
	}
}
