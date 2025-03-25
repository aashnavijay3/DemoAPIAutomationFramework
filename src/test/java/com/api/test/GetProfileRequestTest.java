package com.api.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.LoginRequest;
import com.api.models.LoginResponse;
import com.api.models.UserProfileResponse;

import io.restassured.response.Response;
@Listeners(com.api.listeners.TestListener.class)
public class GetProfileRequestTest {

	@Test(description="Verify if Login API is working...")
	public void getProfileInfoTest()
	{
		AuthService authService = new AuthService();
		LoginRequest loginRequest=new LoginRequest("Aashna","aashna");
		Response response=authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());//using above token we are fetching profile
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		
	}
}
