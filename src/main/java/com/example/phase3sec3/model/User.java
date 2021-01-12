package com.example.phase3sec3.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
//This class serves as the model for the users information 
@Getter
@Builder
public class User {
	
	private String userName;
	
	private String password;
	
	private String role;

}
