package com.maderacnc.MaderaCNC.models;

//POJO de [ Categoria ]
//Plain Old Java Object

public class Categoria {

	// Variables de la categoria
	private int category_id;
	private String category_name;
	private String category_description;
	
	// Variable del contador
	private static int count = 0;
	
	public Categoria (String category_name, String category_description) {
		this.category_name = category_name;
		this.category_description = category_description;
		count++;
		this.category_id = count;
	} // constructor

	public Categoria () {
		count++;
		this.category_id = count;
	} // constructor

	public int getCategory_id () {
		return category_id;
	} // getCategory_id

	public String getCategory_name () {
		return category_name;
	}// getCategory_name

	public void setCategory_name (String category_name) {
		this.category_name = category_name;
	} // setCategory_name

	public String getCategory_description () {
		return category_description;
	} // getCategory_description

	public void setCategory_description (String category_description) {
		this.category_description = category_description;
	} // setCategory_description

	@Override
	public String toString () {
		return "Categoria [category_id=" + category_id + ", category_name=" + category_name + ", category_description="
				+ category_description + "]";
	} // toString
	
} // class Categoria