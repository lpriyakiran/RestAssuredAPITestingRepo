package com.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"username",
"password"
})

public class LoginPOJO {

	private String username;
	private String password;
	
	public LoginPOJO(String userName2, String password2) {
		this.username = userName2;
		this.password = password2;
	}

	public String getUsername() {
	return username;
	}
	
	public void setUsername(String username) {
	this.username = username;
	}
	
	public String getPassword() {
	return password;
	}
	
	public void setPassword(String password) {
	this.password = password;
	}

}