package com.maderacnc.MaderaCNC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// POJO de [ Producto ]
// Plain Old Java Object

@Entity
@Table(name="producto")
public class Producto {

	// Variables del producto
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long product_id;
	@Column (name = "id", unique = true)
	private String product_name;
	private String product_img;
	private double product_cost;
	private String product_status;
	private String product_description;
	private int product_rate;
	private int product_category; // Categoría

	public Producto (Long product_id, String product_name, String product_img, double product_cost, String product_status,
			String product_description, int product_rate, int product_category) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_img = product_img;
		this.product_cost = product_cost;
		this.product_status = product_status;
		this.product_description = product_description;
		this.product_rate = product_rate;
		this.product_category = product_category;
	} // constructor

	public Producto () {
	} // constructor

	public String getProduct_name () {
		return product_name;
	} // getProduct_name

	public void setProduct_name (String product_name) {
		this.product_name = product_name;
	} // setProduct_name

	public String getProduct_img () {
		return product_img;
	} // getProduct_img

	public void setProduct_img (String product_img) {
		this.product_img = product_img;
	} // setProduct_img

	public double getProduct_cost () {
		return product_cost;
	} // getProduct_cost

	public void setProduct_cost (double product_cost) {
		this.product_cost = product_cost;
	} // setProduct_cost

	public String getProduct_status () {
		return product_status;
	} // getProduct_status

	public void setProduct_status (String product_status) {
		this.product_status = product_status;
	} // setProduct_status

	public String getProduct_description () {
		return product_description;
	} // getProduct_description

	public void setProduct_description (String product_description) {
		this.product_description = product_description;
	} // setProduct_description

	public int getProduct_rate () {
		return product_rate;
	} // getProduct_rate

	public void setProduct_rate (int product_rate) {
		this.product_rate = product_rate;
	} // setProduct_rate

	public int getProduct_category () {
		return product_category;
	} // getProduct_category

	public void setProduct_category (int product_category) {
		this.product_category = product_category;
	} // setProduct_category

	public Long getProduct_id () {
		return product_id;
	} // getProduct_id

	@Override
	public String toString () {
		return "Producto [product_id=" + product_id + ", product_name=" + product_name + ", product_img=" + product_img
				+ ", product_cost=" + product_cost + ", product_status=" + product_status + ", product_description="
				+ product_description + ", product_rate=" + product_rate + ", product_category=" + product_category
				+ "]";
	} // toString
	
} // class Producto