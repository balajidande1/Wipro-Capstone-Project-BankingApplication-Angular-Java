package com.wipro.balaji.dto;


import lombok.Data;


@Data
public class AuthenticationRequest {
    
    private String email;

    private String password;
}
