package com.wipro.balaji.dto;



import com.wipro.balaji.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

	private long id;
	private String name;
	private String email;
	private String password;
	private UserRole userRole;


}
