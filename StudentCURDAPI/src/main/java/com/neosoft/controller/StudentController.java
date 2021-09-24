package com.neosoft.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neosoft.model.Student;
import com.neosoft.service.IStudentServiceMgmt;

/**
 * The Class StudentController.
 * 
 * @author Santoshi Yadav
 * 
 */
@Controller
public class StudentController {
	
	/** service class object instantiation */
	@Autowired
	private IStudentServiceMgmt service;
	
	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	/**
	 * Show home page.
	 *
	 * @return the string
	 */
	@GetMapping("/")
	public String showHomePage() {
		logger.trace("home page request");
		return "home";
	}
	
	/**
	 * Show find page.
	 *
	 * @return the string
	 */
	@GetMapping("/find_student")
	public String showFindPage() {
		logger.trace("find student by id page request");
		return "find_student";
	}
	
	/**
	 * Show add student form.
	 *
	 * @param student the student
	 * @return the string
	 */
	@GetMapping("/insert_student")
	public  String   showAddStudentForm(@ModelAttribute("student") Student student) {
		logger.trace("insert student page request");
		return "add_student";
	}
	
	/**
	 * Insert student into DB.
	 *
	 * @param attrs the attributes
	 * @param student the student
	 * @param errors the errors
	 * @return the string
	 */
	@PostMapping("/insert_student")
	public  String insertStudent(RedirectAttributes attrs,
			@ModelAttribute("student")Student student, BindingResult errors) {
			
			String result=service.insertStudent(student);
			logger.debug("insert student status:: "+result);
			attrs.addFlashAttribute("resultMsg",result);
			return "redirect:students_record";
	}
	
	/**
	 * Show All student record.
	 *
	 * @param map the map
	 * @return the string
	 */
	@GetMapping("/students_record")
	public  String showStudentsRecord(Map<String,Object> map) {
		logger.trace("get all student page request");
		Iterable<Student> studentList = service.getAllStudent();
		map.put("studentList", studentList);
		return "students_record";
	}
	
	/**
	 * Show student record by id.
	 *
	 * @param id the id
	 * @param map the map
	 * @return the string
	 */
	@GetMapping("/student_record")
	public String showStudentRecord(@RequestParam("sid") int id, Map<String,Object> map) {
		logger.trace("find student record by id page request");
		Student student =service.getStudentById(id);
		map.put("student", student);
		return  "student_record";
	}
	
}
