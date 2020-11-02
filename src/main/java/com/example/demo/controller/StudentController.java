package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;


@RestController
@CrossOrigin(origins = "http://localhost:4200", 
methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class StudentController {

	@Autowired 
	StudentDao sdao;
	
	@GetMapping("/allstudents")
	public ResponseEntity<List<Student>> allStudents()
	{
		List<Student> allstu;
		allstu = sdao.getAllStudents();
		return new ResponseEntity<List<Student>>(allstu, HttpStatus.OK );//200
		
	}
//	@PostMapping("/addStudent")
	@RequestMapping(value = "/addStudent", method= RequestMethod.POST)
	public ResponseEntity<Student> saveStudent(@RequestBody Student ob )
	{
		sdao.create(ob);
		return new ResponseEntity<Student>(ob, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/updateStudent", method  = RequestMethod.PUT)
	public ResponseEntity<Student> updateStudent(@RequestBody Student ob)
	{
		if(ob != null)
		{
			sdao.updateStudent(ob);
			return new ResponseEntity<Student>(HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student>(HttpStatus.NO_CONTENT); 
					
	}
	
	@RequestMapping(value = "/getstudentbyid/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id)
	{
		Student ob = sdao.getStudentById(id);
		if (ob != null)
		{
			return new ResponseEntity<Student> (ob, HttpStatus.OK);
		}
		else
			return new ResponseEntity<Student> (HttpStatus.NO_CONTENT);
	}
	@RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Student> deleteStudent(@PathVariable int id)
	{
		sdao.deleteStudent(id);
		return new ResponseEntity<Student> (HttpStatus.OK);
	}
}
