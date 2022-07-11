package com.maderacnc.MaderaCNC.models;

import javax.persistence.*;

@Entity
@Table(name="imagen")
public class Imagen {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (unique = true, nullable = false)
	private Long id_imagen;
	private String img;
	private int product_id;
	
	public Imagen(Long id_imagen, String img, int product_id) {
		this.id_imagen = id_imagen;
		this.img = img;
		this.product_id = product_id;
	}// constructor

	public Imagen() {
	}// default Constructor
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Long getId_imagen() {
		return id_imagen;
	}

	@Override
	public String toString() {
		return "Imagen [id_imagen=" + id_imagen + ", img=" + img + ", product_id=" + product_id + "]";
	}
	
	
}// class Imagen
