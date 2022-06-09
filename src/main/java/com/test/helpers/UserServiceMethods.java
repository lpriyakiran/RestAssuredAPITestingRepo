package com.test.helpers;

import java.util.ArrayList;

import com.test.constatnts.Endpoints;
import com.test.models.AddUserPOJO;
import com.test.models.DeleteUserPOJO;
import com.test.models.GetUserPOJO;
import com.test.models.LoginPOJO;
import com.test.models.UpdateUserPOJO;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceMethods {
	
	protected static String bToken;
	static Response resp;
	static String userId;
	static String id;
	
	public static String getBaseUri() {
		String baseUri = Utils.getConfigProperty("baseUri");
		return baseUri;
	}
	
	public static Response loginToApi() {
		String userName = Utils.getConfigProperty("username");
		String password = Utils.getConfigProperty("password");
		
		LoginPOJO login = new LoginPOJO(userName, password);
		
		resp = RestAssured.given()
		.contentType(ContentType.JSON)
		.body(login)
		.baseUri(getBaseUri())
		//.log().all()
		.when()
		.post(Endpoints.LOGIN);
		
		return resp;
	}
	
	public static String getToken() {
		resp = loginToApi();
		//resp.then().log().all();
		bToken = resp.jsonPath().get("[0].token");
		System.out.println(bToken);
		return bToken;
	}
	
	public static GetUserPOJO[] getUserData(){
		resp = RestAssured.given()
				.header("token", bToken)
				.baseUri(getBaseUri())
				.when()
				.get(Endpoints.GET_DATA);
		ArrayList<GetUserPOJO> userData = resp.jsonPath().get("findAll(a->a.accountno=='TA-3434343')");
		System.out.println("First record= "+userData.get(0));
		
		GetUserPOJO[] userList = resp.as(GetUserPOJO[].class);
		//retrieve userid and id for next steps
		userId = userList[0].getUserid();
		id = userList[0].getId();
		return userList;
	}
	
	public static Response addUserData(){
		AddUserPOJO addUser = new AddUserPOJO();
		addUser.setAccountno("TA-3434344");
		addUser.setDepartmentno("1");
		addUser.setSalary("500");
		addUser.setPincode("222222");
		
		resp = RestAssured.given()
				.contentType(ContentType.JSON)
				.header("token", bToken)
				.baseUri(getBaseUri())
				.body(addUser)
				//.log().body()
				.when()
				.post(Endpoints.ADD_DATA);
		return resp;
	}
	
	public static Response updateUserData(){
		UpdateUserPOJO update = new UpdateUserPOJO();
		update.setAccountno("TA-3434344");
		update.setDepartmentno(2);
		update.setSalary(1000);
		update.setPincode(222222);
		update.setUserid(userId);
		update.setId(id);
		
		resp = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(update)
				.baseUri(getBaseUri())
				.header("token",bToken)
				//.log().body()
				.when()
				.put(Endpoints.UPDATE_DATA);
		
		return resp;
	}
	
	public static Response deleteUserData(){
		DeleteUserPOJO delete = new DeleteUserPOJO();
		delete.setUserid(userId);
		delete.setId(id);
		
		resp = RestAssured.given()
				.contentType(ContentType.JSON)
				.header("token", bToken)
				.baseUri(getBaseUri())
				.body(delete)
				//.log().body()
				.when()
				.delete(Endpoints.DELETE_DATA);
		return resp;
	}
}
