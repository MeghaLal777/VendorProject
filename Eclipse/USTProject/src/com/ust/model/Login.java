package com.ust.model;

public class Login {

	// instance variables

	private int userId;
	private String userName;
	private String password;

	// default constructor

	public Login() {
		super();

	}

	// parameterized constructor

	public Login(int userId, String userName, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	// getters and setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
