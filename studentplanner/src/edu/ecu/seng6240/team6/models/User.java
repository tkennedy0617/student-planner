package edu.ecu.seng6240.team6.models;

import com.google.gson.JsonObject;


public class User {
	public static final String STUDENT_ROLE = "User";
	public static final String ADIN_ROLE = "Admin";
	
	private int id = -1;
	private String lastName = null;
	private String firstName = null;
	private String userName = null;
	private String role = null;
	public User(){
		
	}
	
	public User(JsonObject jsonObject)
	{
		this.id = jsonObject.has("id")?jsonObject.get("id").getAsInt():-1;
		this.lastName = jsonObject.has("lastName")?jsonObject.get("lastName").getAsString():null;
		this.firstName = jsonObject.has("firstName")?jsonObject.get("firstName").getAsString():null;
		this.userName = jsonObject.has("username")?jsonObject.get("username").getAsString():null;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}