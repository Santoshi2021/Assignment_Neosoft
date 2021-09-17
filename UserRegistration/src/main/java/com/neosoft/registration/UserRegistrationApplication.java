package com.neosoft.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * The Class UserRegistrationApplication.
 * 
 * @author Santoshi Yadav
 * 
 */
@SpringBootApplication
@EnableSwagger2
public class UserRegistrationApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}

}
