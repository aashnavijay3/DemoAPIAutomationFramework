package com.api.test;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description="Verify if Login API is working...")
	public void createAccountTest()
	{
		SignUpRequest signUpRequest= new SignUpRequest.Builder().userName("stuti4")
				.email("aashnavijay8@gmail.com")
				.firstName("stuti4")
				.lastName("sharma")
				.password("test@1234")
				.mobileNumber("9876543210")
				.build();
		
		AuthService authService=new AuthService();
		Response response=authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		System.out.println(response.getBody());
				
				
	}
	
}
