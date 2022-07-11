package com.maderacnc.MaderaCNC.models;

import javax.persistence.*;

//POJO de [ Categoria ]
//Plain Old Java Object
@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private int category_id;
	private String category_name;
	private String category_description;
	
	public Categoria (String category_name, String category_description) {
		this.category_name = category_name;
		this.category_description = category_description;
	} // constructor

	public Categoria () {
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
