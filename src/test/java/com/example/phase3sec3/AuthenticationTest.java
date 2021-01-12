package com.example.phase3sec3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.phase3sec3.model.User;

//This test class is used to test my user authorization within the application
public class AuthenticationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("Matt").password("pass").role("Admin").build());
		Authentication.userList.add(User.builder().userName("Donny").password("pass").role("User").build());
		Authentication.userList.add(User.builder().userName("Chris").password("pass").role("Developer").build());
		Authentication.userList.add(User.builder().userName("Patt").password("pass").role("Tester").build());
	}
	
	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
	}
	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(false, authentication.login("Omar", "pass"));
	}

	@Test
	public void testUserAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
		
		assertEquals("Matt", authentication.getUserName());
	}
	
	@Test
	public void testRoleAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
		
		assertEquals("Admin", authentication.getRole());
	}

	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
		
		authentication.logout();
		
		assertEquals(null, authentication.getRole());
	}

}
