package com.example.phase3sec3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.phase3sec3.model.User;
//This test class is used to test my user authentication within the application
public class AuthorizationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("Matt").password("pass").role("Admin").build());
		Authentication.userList.add(User.builder().userName("Donny").password("pass").role("User").build());
		Authentication.userList.add(User.builder().userName("Chris").password("pass").role("Developer").build());
		Authentication.userList.add(User.builder().userName("Patt").password("pass").role("Tester").build());
	}
	
	@Test
	public void testWelcomePageAccess() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
		
		Authorization authorization = new Authorization(authentication);
		
		assertEquals(true, authorization.hasAccess("welcome"));
	}
	
	@Test
	public void testAdminPageAccess() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
		
		Authorization authorization = new Authorization(authentication);
		
		assertEquals(true, authorization.hasAccess("admin"));

	}
	
	@Test
	public void testAdminPageNotAccessable() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Patt", "pass"));
		
		Authorization authorization = new Authorization(authentication);
		
		assertEquals(false, authorization.hasAccess("admin"));

	}


	@Test
	public void testWelcomePageAccessWithoutLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Matt", "pass"));
		
		authentication.logout();
		
		Authorization authorization = new Authorization(authentication);
		
		assertEquals(false, authorization.hasAccess("admin"));

		
	}
}
