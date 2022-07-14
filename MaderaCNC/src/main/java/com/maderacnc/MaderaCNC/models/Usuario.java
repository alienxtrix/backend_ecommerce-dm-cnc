package com.maderacnc.MaderaCNC.models;

import javax.persistence.*;

//POJO de [ Usuario ]
//Plain Old Java Object

@Entity
@Table (name = "usuario")
public class Usuario {
	
	// Variables del usuario
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long user_id;
	private String user_name;
	private String user_lastNF;
	private String user_lastNM;
	private String user_date;
	private String user_pass;
	private String user_phone;
	private String user_email;
	private Integer user_type_id;
	
	public Usuario (Long user_id, String user_name, String user_lastNF, String user_lastNM, String user_date, String user_pass, String user_phone, String user_email, Integer user_type_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_lastNF = user_lastNF;
		this.user_lastNM = user_lastNM;
		this.user_date = user_date;
		this.user_pass = user_pass;
		this.user_phone = user_phone;
		this.user_email = user_email;
		this.user_type_id = user_type_id;
	} // Constructor
	
	public Usuario () {	
	} // Constructor
	
	public int getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(Integer user_type_id) {
		this.user_type_id = user_type_id;
	}

	public Long getUser_id () {
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
	public String toString() {
		return "Usuario [user_id=" + user_id + ", user_name=" + user_name + ", user_lastNF=" + user_lastNF
				+ ", user_lastNM=" + user_lastNM + ", user_date=" + user_date + ", user_pass=" + user_pass
				+ ", user_phone=" + user_phone + ", user_email=" + user_email + ", userType_id=" + user_type_id + "]";
	} // toString
	
} // class Usuario
