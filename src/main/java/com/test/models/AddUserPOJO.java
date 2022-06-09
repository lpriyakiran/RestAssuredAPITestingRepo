package com.test.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"accountno",
"departmentno",
"salary",
"pincode"
})
public class AddUserPOJO {
	
	private String accountno;
	private String departmentno;
	private String salary;
	private String pincode;
	
	public AddUserPOJO() {

	}

	public String getAccountno() {
	return accountno;
	}
	
	public void setAccountno(String accountno) {
	this.accountno = accountno;
	}
	
	public String getDepartmentno() {
	return departmentno;
	}
	
	public void setDepartmentno(String departmentno) {
	this.departmentno = departmentno;
	}
	
	public String getSalary() {
	return salary;
	}
	
	public void setSalary(String salary) {
	this.salary = salary;
	}
	
	public String getPincode() {
	return pincode;
	}
	
	public void setPincode(String pincode) {
	this.pincode = pincode;
	}

}