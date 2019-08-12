package com.yodlee.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yodlee.entity.Student;

@RestController
@RequestMapping("/api")
public class TestRestController {
	
	List<Student> theStudent = new ArrayList<>();
	

	@PostConstruct
	public void loadData()
	{
		theStudent.add(new Student("abhishek","sharma"));
		theStudent.add(new Student("jaya","A K"));
		theStudent.add(new Student("rohit","kumawat"));
		theStudent.add(new Student("ankit","kumar"));
	}
	
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello World";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents()
	{
		
		return theStudent;
	}
	
	
	
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if( (studentId >= theStudent.size() || (studentId < 0)))
		{
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudent.get(studentId);
	}
	
	// add an exception handler using @ExceptionHandler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e)
	{
		// create a studenterrorresponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		// return responseentity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e)
	{
		// create a studenterrorresponse
		StudentErrorResponse error = new StudentErrorResponse();
	error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		
		// return responseentity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		
	}
	
	
	
	
}

