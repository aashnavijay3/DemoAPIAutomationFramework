package com.api.base;

import java.util.HashMap;

import com.api.models.LoginRequest;
import com.api.models.SignUpRequest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthService extends BaseService {

	private static final String BASE_PATH="api/auth/";
	
	
	public Response login(LoginRequest loginRequest)
	{
		return postRequest(loginRequest,BASE_PATH+"login");
	}
	
	public Response signUp(SignUpRequest signUpRequest)
	{
		return postRequest(signUpRequest,BASE_PATH+"signup");
	}
	
	public Response forgotPassword(String emailAddress)
	{
		HashMap<String,String> payload=new HashMap<String,String>();
		payload.put("email", emailAddress);
		return postRequest(emailAddress,BASE_PATH+"forgotPassword");
	}

}
