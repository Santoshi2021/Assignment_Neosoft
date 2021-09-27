package com.neosoft.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neosoft.model.Project;
import com.neosoft.model.Student;
import com.neosoft.util.UserDetailsServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class StudentValidator.
 * 
 * @author Santoshi Yadav
 * 
 */
@Component
public class StudentValidator implements Validator {

	/** The logger. */
	private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Student.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		logger.debug("Server side validation");
		if (student.getFname() == null || student.getFname().isBlank())
			errors.rejectValue("fname", "s.fname.required");
		else if (student.getFname().length() < 2)
			errors.rejectValue("fname", "s.fname.minlength");
		else if (student.getFname().length() > 16)
			errors.rejectValue("fname", "s.fname.maxlength");

		if (student.getLname() == null || student.getLname().isBlank())
			errors.rejectValue("lname", "s.lname.required");
		else if (student.getLname().length() < 2)
			errors.rejectValue("lname", "s.lname.minlength");
		else if (student.getLname().length() > 16)
			errors.rejectValue("lname", "s.lname.maxlength");

		if (student.getMobile() == null)
			errors.rejectValue("Mobile", "s.mobile.required");
		else if (student.getMobile() < 7000000000l || student.getMobile() > 9999999999l)
			errors.rejectValue("mobile", "s.mobile.range");

		if (student.getEmail() == null || student.getEmail().isBlank())
			errors.rejectValue("email", "s.email.required");
		else if (!student.getEmail().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
			errors.rejectValue("email", "s.email.invalid");

		if (student.getProject().getPname() == null || student.getProject().getPname().isBlank())
			errors.rejectValue("pname", "s.pname.required");
		else if (student.getProject().getPname().length() < 5)
			errors.rejectValue("pname", "s.pname.minlength");
		else if (student.getProject().getPname().length() > 50)
			errors.rejectValue("pname", "s.pname.maxlength");

		if (student.getProject().getDuration() == null)
			errors.rejectValue("duration", "s.duration.required");
		else if (student.getProject().getDuration() <= 0)
			errors.rejectValue("duration", "s.duration.range");
	}

}