package com.maderacnc.MaderaCNC.models;

public class Login {
	private String user_email;
	private String user_pass;
	
	
	public Login(String user_email, String user_pass) {
		super();
		this.user_email = user_email;
		this.user_pass = user_pass;
	}
	
	public Login() {}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	@Override
	public String toString() {
		return "Login [user_email=" + user_email + ", user_pass=" + user_pass + "]";
	}
	
	
}
