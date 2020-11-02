package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentDao {

	public List<Student> getAllStudents();
	public void create(Student ob);
	public void updateStudent(Student ob);
	public Student getStudentById(int id);
	public void deleteStudent(int id);
	
}
