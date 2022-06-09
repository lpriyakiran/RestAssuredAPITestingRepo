package com.test.tests;

import org.testng.annotations.Test;

import com.test.constatnts.SourcePath;
import com.test.helpers.UserServiceMethods;
import com.test.models.GetUserPOJO;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;;

public class EndToEndTesting extends UserServiceMethods{
	
	@Test(priority = 1)
	public static void TC_001_validLogin(){
		String token = getToken();
		System.out.println("Current token----"+token);	
	}
	
	@Test(priority = 2)
	public static void TC_002_addUserData(){
		Response resp = addUserData();
		resp.then()
		.log().body()
		.statusCode(201)
		.assertThat()
		.body(matchesJsonSchemaInClasspath(SourcePath.SCHEMA_FILE_PATH));	
	}
	
	@Test(priority = 3, enabled = true)
	public static void TC_003_getUserData(){
		GetUserPOJO[] userData = getUserData();
		System.out.println("Number of records= "+userData.length);
		System.out.println("First record's account num= "+userData[0].getAccountno());	
	}
	
	@Test(priority = 4, enabled = true)
	public static void TC_004_updateUserData(){
		Response resp = updateUserData();
		resp.then().log().body()
		.statusCode(200)
		.assertThat()
		.body(matchesJsonSchemaInClasspath(SourcePath.SCHEMA_FILE_PATH));	
	}
	
	@Test(priority = 5, enabled = true)
	public static void TC_005_deleteUserData(){
		Response resp = deleteUserData();
		resp.then().log().body()
		.statusCode(200)
		.assertThat()
		.body(matchesJsonSchemaInClasspath(SourcePath.SCHEMA_FILE_PATH));
	}

}
