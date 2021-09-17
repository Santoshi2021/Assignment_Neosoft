/**
 * 
 */
package com.neosoft.registration.service;

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
import com.neosoft.registration.repositry.IUserRegistrationRepo;

/**
 * The Class UserRegistrationServiceMgmtImplTest.
 *
 * @author Santoshi Yadav
 */
@RunWith(MockitoJUnitRunner.class)
@Transactional
@SpringBootTest
class UserRegistrationServiceMgmtImplTest {

	/** The service. */
	@InjectMocks
    UserRegistrationServiceMgmtImpl service;
     
    /** The repo. */
    @Mock
    IUserRegistrationRepo repo;
    
    /** The list. */
    static List<User> list = null;
    
    /** The user list. */
    static List<User> userList = null;
	
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
	 * Test method for {@link com.neosoft.registration.service.UserRegistrationServiceMgmtImpl#getByFirstName(java.lang.String)}.
	 */
	@Test
	void testGetByFirstName() {
		
		when(repo.findByFnameAndIsActive("Raja", 1))
		.thenReturn(list);
		  
		userList = service.getByFirstName("Raja");
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.service.UserRegistrationServiceMgmtImpl#getByLastName(java.lang.String)}.
	 */
	@Test
	void testGetByLastName() {
		
		when(repo.findByLnameAndIsActive("Babu", 1)).thenReturn(list);
		  
		userList = service.getByLastName("Babu");
		  
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.service.UserRegistrationServiceMgmtImpl#getByPincode(java.lang.Integer)}.
	 */
	@Test
	void testGetByPincode() {  

		when(repo.findByPincodeAndIsActive(462016, 1)).thenReturn(list);
		  
		userList = service.getByPincode(462016);
		  
		assertEquals(1, userList.size());
		
	}

	/**
	 * Test method for {@link com.neosoft.registration.service.UserRegistrationServiceMgmtImpl#getAllOrderOfDOB()}.
	 */
	@Test
	void testGetAllOrderOfDOB() {
		
		when(repo.findAllOrderByDOBAndIsActive(1)).thenReturn(list);
		
		userList = service.getAllOrderOfDOB();
		
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.service.UserRegistrationServiceMgmtImpl#getAllOrderOfDOJ()}.
	 */
	@Test
	void testGetAllOrderOfDOJ() {
		
		when(repo.findAllOrderByDOJAndIsActive(1)).thenReturn(list);
		
		userList = service.getAllOrderOfDOJ();
		
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.service.UserRegistrationServiceMgmtImpl#findAllUser()}.
	 */
	@Test
	void testFindAllUser() {
		
		when(repo.findAllIsActive(1)).thenReturn(list);
		
		userList = service.findAllUser();
		
		assertEquals(1, userList.size());
	}


}
