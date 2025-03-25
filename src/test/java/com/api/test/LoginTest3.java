package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.LoginRequest;
import com.api.models.LoginResponse;

import io.restassured.response.Response;

public class LoginTest3 {

	@Test(description="Verify if Login API is working...")
	public void loginTest()
	{
		LoginRequest loginRequest = new LoginRequest("Aashna","aashna");
		AuthService authService=new AuthService();
		Response response=authService.login(loginRequest);
		
		LoginResponse loginResponse=response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getEmail(), "aashnavijay03@gmail.com");
	}
}                         