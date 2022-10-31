package com.wds.jee;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("in28Minutes") && password.equalsIgnoreCase("dummy");
	}

}