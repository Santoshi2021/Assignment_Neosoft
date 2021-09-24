package com.neosoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.controller.StudentController;
import com.neosoft.model.Student;
import com.neosoft.repository.IStudentRepo;

/**
 * The Class StudentServiceMgmtImplementation.
 * 
 * @author Santoshi Yadav
 * 
 */
@Service
public class StudentServiceMgmtImpl implements IStudentServiceMgmt {

	/** The repo. */
	@Autowired
	private IStudentRepo repo;
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	/**
	 * Insert student.
	 *
	 * @param s the student
	 * @return the string
	 */
	@Override
	public String insertStudent(Student student) {
		logger.trace("Student service class insert operation");
		return "Student inserted with id value:: "+repo.save(student).getId();
	}

	/**
	 * Gets the all student.
	 *
	 * @return the all student
	 */
	@Override
	public Iterable<Student> getAllStudent() {
		logger.trace("Student service class select operation");
		return repo.findAll();
	}

	/**
	 * Gets the student by id.
	 *
	 * @param id the id
	 * @return the student by id
	 */
	@Override
	public Student getStudentById(Integer id) {
		logger.trace("Student service class select by id operation");
		return repo.findById(id).get();
	}

}
