package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.LoginRequest;
import com.api.models.LoginResponse;
import com.api.models.ProfileRequest;
import com.api.models.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description="Verify if Login API is working...")
	public void updateProfileTest()
	{
		AuthService authService = new AuthService();
		LoginRequest loginRequest=new LoginRequest("Aashna","aashna");
		Response response=authService.login(loginRequest);
		LoginResponse loginResponse=response.as(LoginResponse.class);
		System.out.println("-----------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "Aashna");
		
		System.out.println("-----------------------------------------------------");
		
		ProfileRequest ProfileRequest=new ProfileRequest.Builder().firstName("Aashna")
				.lastName("Vijay")
				.email("aashnavijay03@gmail.com")
				.mobileNumber("9899827501")
				.Build();
				
		response=userProfileManagementService.updateProfile(loginResponse.getToken(), ProfileRequest);
		System.out.println(response.asPrettyString());
	}
}
