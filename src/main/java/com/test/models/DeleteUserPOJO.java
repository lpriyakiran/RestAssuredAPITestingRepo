package com.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"userid"
})
public class DeleteUserPOJO {
	private String id;
	private String userid;
	
	public String getId() {
	return id;
	}
	
	public void setId(String id) {
	this.id = id;
	}
	
	public String getUserid() {
	return userid;
	}
	
	public void setUserid(String userid) {
	this.userid = userid;
	}

}