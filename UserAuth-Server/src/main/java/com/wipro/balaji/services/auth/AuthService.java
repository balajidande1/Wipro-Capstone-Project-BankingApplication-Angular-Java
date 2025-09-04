package com.wipro.balaji.services.auth;

import com.wipro.balaji.dto.SignupRequest;
import com.wipro.balaji.dto.UserDto;

public interface AuthService 
{

	UserDto signupUser(SignupRequest signupRequest);
	boolean hasUserWithEmail(String email);
}
