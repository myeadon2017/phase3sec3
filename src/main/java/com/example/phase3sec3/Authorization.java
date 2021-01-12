package com.example.phase3sec3;

//This class serves as business logic for user authorization
public class Authorization {

	private Authentication authentication;

	public Authorization(Authentication authentication) {

		this.authentication = authentication;
	}

	public boolean hasAccess(String page) {

		
		if(authentication != null && authentication.getRole() != null) {
			if(page.equals("welcome")) {
				return true;
			} else if(page.equals("admin")) {
				if(authentication.getRole().equals("Admin")) {
					return true;
				}
			}
		}

		return false;
	}
	
	

}
