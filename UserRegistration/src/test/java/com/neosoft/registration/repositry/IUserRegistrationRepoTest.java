/**
 * 
 */
package com.neosoft.registration.repositry;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.registration.entity.Address;
import com.neosoft.registration.entity.User;

/**
 * @author Santoshi Yadav
 *
 */
@RunWith(MockitoJUnitRunner.class)
@Transactional
@SpringBootTest
class IUserRegistrationRepoTest {

    @Mock
    IUserRegistrationRepo repo;

    static List<User> list = null;
    
    static List<User> userList = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		User user1 = new User(101, "Raja", "Babu", "er.raja@gmail.com",
				LocalDate.of(1995, 06, 10), LocalDate.of(2021, 01, 06), 1, new Address(101,
				"1/10", "Sartia Complex", "Shivaji Nagar", "Mumbai", 462016));
				
		list = List.of(user1);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.neosoft.registration.repositry.IUserRegistrationRepo#findByFnameAndIsActive(java.lang.String, java.lang.Integer)}.
	 */
	@Test
	void testFindByFnameAndIsActive() {
		when(repo.findByFnameAndIsActive("Raja", 1)).thenReturn(list);
		
		userList = repo.findByFnameAndIsActive("Raja", 1);
		assertEquals("Raja", userList.get(0).getFname());
	}

	/**
	 * Test method for {@link com.neosoft.registration.repositry.IUserRegistrationRepo#findByLnameAndIsActive(java.lang.String, java.lang.Integer)}.
	 */
	@Test
	void testFindByLnameAndIsActive() {
		when(repo.findByLnameAndIsActive("Babu", 1)).thenReturn(list);
		
		userList = repo.findByLnameAndIsActive("Babu", 1);
		assertEquals("Babu", userList.get(0).getLname());
	}

	/**
	 * Test method for {@link com.neosoft.registration.repositry.IUserRegistrationRepo#findByIdAndIsActive(java.lang.Long, java.lang.Integer)}.
	 */
	@Test
	void testFindByIdAndIsActive() {
		User expected = new User(101, "Raja", "Babu", "er.raja@gmail.com",
				LocalDate.of(1995, 06, 10), LocalDate.of(2021, 01, 06), 1, new Address(101,
				"1/10", "Sartia Complex", "Shivaji Nagar", "Mumbai", 462016));
		
		when(repo.findById(101)).thenReturn(Optional.of(expected));
		Optional<User> actual = repo.findById(101);
		assertEquals(expected.getId(), actual.get().getId());
	}

	/**
	 * Test method for {@link com.neosoft.registration.repositry.IUserRegistrationRepo#findAllOrderByDOBAndIsActive(java.lang.Integer)}.
	 */
	@Test
	void testFindAllOrderByDOBAndIsActive() {
		
		when(repo.findAllOrderByDOBAndIsActive(1)).thenReturn(list);
		userList = repo.findAllOrderByDOBAndIsActive(1);
		
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.repositry.IUserRegistrationRepo#findAllOrderByDOJAndIsActive(java.lang.Integer)}.
	 */
	@Test
	void testFindAllOrderByDOJAndIsActive() {
		
		when(repo.findAllOrderByDOJAndIsActive(1)).thenReturn(list);
		userList = repo.findAllOrderByDOJAndIsActive(1);
		
		assertEquals(1, userList.size());
	}

	/**
	 * Test method for {@link com.neosoft.registration.repositry.IUserRegistrationRepo#findByPincodeAndIsActive(java.lang.Integer, java.lang.Integer)}.
	 */
	@Test
	void testFindByPincodeAndIsActive() {
		
		when(repo.findByPincodeAndIsActive(101, 1)).thenReturn(list);
		
		userList = repo.findByPincodeAndIsActive(101, 1);
		
		assertEquals(1, userList.size());
	}

}
