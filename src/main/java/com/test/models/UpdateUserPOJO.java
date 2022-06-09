package com.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accountno",
"departmentno",
"salary",
"pincode",
"userid",
"id"
})

public class UpdateUserPOJO {
	private String accountno;
	private Integer departmentno;
	private Integer salary;
	private Integer pincode;
	private String userid;
	private String id;
	
	public String getAccountno() {
	return accountno;
	}
	
	public void setAccountno(String accountno) {
	this.accountno = accountno;
	}
	
	public Integer getDepartmentno() {
	return departmentno;
	}
	
	public void setDepartmentno(Integer departmentno) {
	this.departmentno = departmentno;
	}
	
	public Integer getSalary() {
	return salary;
	}
	
	public void setSalary(Integer salary) {
	this.salary = salary;
	}
	
	public Integer getPincode() {
	return pincode;
	}
	
	public void setPincode(Integer pincode) {
	this.pincode = pincode;
	}
	
	public String getUserid() {
	return userid;
	}
	
	public void setUserid(String userid) {
	this.userid = userid;
	}
	
	public String getId() {
	return id;
	}
	
	public void setId(String id) {
	this.id = id;
	}

}