/**
 * 
 */
package com.neosoft.registration.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.registration.entity.Address;
import com.neosoft.registration.entity.User;
import com.neosoft.registration.service.IUserRegistrationMgmtService;

/**
 * @author Santoshi Yadav
 *
 */
@RunWith(MockitoJUnitRunner.class)
@Transactional
@SpringBootTest
class UserRegistrationControllerTest {

	/** The controller. */
	@InjectMocks
    UserRegistrationController controller;
     
    /** The service */
    @Mock
    IUserRegistrationMgmtService service;
    
    /** The list. */
    static List<User> list = null;
    
    /** The user list. */
    static List<User> userList = null;
	
	/**
	 * @throws java.lang.Exception
	 */
    /**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	
		  
		User user1 = new User(101, "Raja", "Babu", "er.raja@gmail.com",
		LocalDate.of(1995, 06, 10), LocalDate.of(2021, 01, 06), 1, new Address(101,
		"1/10", "Sartia Complex", "Shivaji Nagar", "Bhopal", 462016));
		
		list = List.of(user1);
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
		List<User> userList = null;
	}


	/**
	 * Test method for {@link com.neosoft.registration.controller.UserRegistrationController#getAllUser()}.
	 */
	@Test
	void testGetAllUser() {
		when(service.findAllUser()).thenReturn(list);
		  
		userList = controller.getAllUser();
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.controller.UserRegistrationController#getUserByPincode(java.lang.Integer)}.
	 */
	@Test
	void testGetUserByPincode() {
		when(service.getByPincode(462016)).thenReturn(list);
		  
		userList = controller.getUserByPincode(462016);
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.controller.UserRegistrationController#getUsersByDOJ()}.
	 */
	@Test
	void testGetUsersByDOJ() {
		when(service.getAllOrderOfDOJ()).thenReturn(list);
		  
		userList = controller.getUsersByDOJ();
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.controller.UserRegistrationController#getUsersByDOB()}.
	 */
	@Test
	void testGetUsersByDOB() {
		when(service.getAllOrderOfDOB()).thenReturn(list);
		  
		userList = controller.getUsersByDOB();
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.controller.UserRegistrationController#getUserByFirstName(java.lang.String)}.
	 */
	@Test
	void testGetUserByFirstName() {
		when(service.getByFirstName("Raja")).thenReturn(list);
		  
		userList = controller.getUserByFirstName("Raja");
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.controller.UserRegistrationController#getUserByLastName(java.lang.String)}.
	 */
	@Test
	void testGetUserByLastName() {
		when(service.getByLastName("Raja")).thenReturn(list);
		  
		userList = controller.getUserByLastName("Raja");
		  
		assertEquals(1, userList.size());
	}

}
