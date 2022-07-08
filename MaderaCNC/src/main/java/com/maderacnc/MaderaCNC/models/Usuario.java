package com.maderacnc.MaderaCNC.models;

//POJO de [ Usuario ]
//Plain Old Java Object


public class Usuario {
	
	// Variables del usuario
	private int user_id;
	private String user_name;
	private String user_lastNF;
	private String user_lastNM;
	private String user_date;
	private String user_pass;
	private String user_phone;
	private String user_email;
	private static int count = 0; // Contador
	
	public Usuario (String user_name, String user_lastNF, String user_lastNM, String user_date, String user_pass, String user_phone, String user_email) {
		super();
		this.user_name = user_name;
		this.user_lastNF = user_lastNF;
		this.user_lastNM = user_lastNM;
		this.user_date = user_date;
		this.user_pass = user_pass;
		this.user_phone = user_phone;
		this.user_email = user_email;
		count++;
		this.user_id=count;
	} // Constructor
	
	public Usuario () {	
		count ++;
		this.user_id=count;
	} // Constructor
	
	public int getUser_id () {
		return user_id;
	} // getUser_id
	
	public String getUser_name () {
		return user_name;
	} // getUser_name
	
	public void setUser_name (String user_name) {
		this.user_name = user_name;
	} // setUser_name
	
	public String getUser_lastNF () {
		return user_lastNF;
	} // getUser_lastNF
	
	public void setUser_lastNF (String user_lastNF) {
		this.user_lastNF = user_lastNF;
	} // setUser_lastNF
	
	public String getUser_lastNM () {
		return user_lastNM;
	} // getUser_lastNM
	
	public void setUser_lastNM (String user_lastNM) {
		this.user_lastNM = user_lastNM;
	} // setUser_lastNM
	
	public String getUser_date () {
		return user_date;
	} // getUser_date
	
	public void setUseR_date (String user_date) {
		this.user_date = user_date;
	} // setUser_date
	
	public String getUser_pass () {
		return user_pass;
	} // getUser_pass
	
	public void setUser_pass (String user_pass) {
		this.user_pass = user_pass;
	} // setUser_pass
	
	public String getUser_phone () {
		return user_phone;
	} // getUser_phone
	
	public void setUser_phone (String user_phone) {
		this.user_phone = user_phone;
	} // setUser_phone
	
	public String getUser_email () {
		return user_email;
	} // getUser_email
	
	public void setUser_email (String user_email) {
		this.user_email = user_email;
	} // setUser_email
	
	@Override
	public String toString () {
		return "Usuario [nombre=" + user_name + ", apellidoP=" + user_lastNF + ", apellidoM=" + user_lastNM + ", fechaNac="
				+ user_date + ", contraseña=" + user_pass + ", numero=" + user_phone + ", email=" + user_email + "]";
	} // toString
	
} // class Usuario