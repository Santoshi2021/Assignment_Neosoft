package com.neosoft.service;

import com.neosoft.model.Student;

/**
 * The Interface IStudentServiceMgmt.
 * 
 * @author Santoshi Yadav
 * 
 */
public interface IStudentServiceMgmt {
	
	/**
	 * Insert student.
	 *
	 * @param s the student
	 * @return the string
	 */
	public String insertStudent(Student student);
	
	/**
	 * Gets the all student.
	 *
	 * @return the all student
	 */
	public Iterable<Student> getAllStudent();
	
	/**
	 * Gets the student by id.
	 *
	 * @param id the id
	 * @return the student by id
	 */
	public Student getStudentById(Integer id);

}
