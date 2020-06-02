package com.luv2code.springboot.demo.mycoolapp.rest;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.entities.Student;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class StudentRestController {

	
	private List <Student> theStudent;

	/* load the data only once */
	@PostConstruct
	public void  loaddata(){
		
		theStudent = new ArrayList<>();
		
		theStudent.add(new Student("Daryl","Johnson"));
		theStudent.add(new Student("Carl","Gillmore"));
		theStudent.add(new Student("Judith","Lockwood"));
	}
	@GetMapping("/students")
	@ApiOperation(value = "get the list of students",
	notes = "Directly returns the list of students",
	response = Student.class)
	@ApiResponses({
        @ApiResponse(code = 200, message = "Request entry"),
        @ApiResponse(code = 404, message = "Entry not found")
    })
	public List<Student> getStudents(){

		return theStudent;
		
	}
	
	@GetMapping("/students/{studentID}")
	public Student getStudent(@PathVariable int studentID) {
		
		return theStudent.get(studentID);
			
	}

}
