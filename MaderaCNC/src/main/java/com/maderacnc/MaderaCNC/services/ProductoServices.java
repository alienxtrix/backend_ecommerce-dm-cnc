package com.maderacnc.MaderaCNC.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.maderacnc.MaderaCNC.models.Producto;

@Service
public class ProductoServices {

	public final ArrayList<Producto> product_list = new ArrayList<Producto>();
	
	public ProductoServices () {
		product_list.add(new Producto("Base para audífonos", "http://drive.google.com/uc?export=view&id=1fv7KLW4Yi1rYmQ5MzFR8-CP6el-pBpUJ", 
				500, "activo", "Base para audífonos y/o auriculares hecho 100% de madera de resistente de alta calidad con textura natural.",
				4, 3));
		product_list.add(new Producto("Bandeja para despicar hierbas", "http://drive.google.com/uc?export=view&id=1BKNTj5hICy-YmiveV4_7TTALPwlvCB70", 
				350, "activo", "Bandeja con varios compartimientos, hecho 100% de madera conocido por ser duradero y resistente mientras que ligero.",
				5, 2));
	} // productoServices
	
	public ArrayList<Producto> getProducts () {
		return product_list;
	} // getProducts
	
	public Producto getProduct (Long id) {
		Producto tmpProduct = null;
		for (Producto product : product_list) {
			if (product.getProduct_id() == id) {
				tmpProduct = product;
				break;
			} // if
		} // foreach
		return tmpProduct;
	} // getProduct
	
	public Producto deleteProduct (Long id) {
		Producto tmpProduct = null;
		for (Producto product : product_list) {
			if (product.getProduct_id() == id) {
				tmpProduct = product_list.remove(product_list.indexOf(product));
				break;
			} // if
		} // foreach
		return tmpProduct;
	} // deleteProduct

	public Producto addProduct (Producto product) {
		product_list.add(product);
		return product;
	} // deleteProduct

	public Producto updateProduct (Long product_id, String product_name, String product_img, Double product_cost,
			String product_status, String product_description, Integer product_rate, Integer product_category) {
		Producto tmpProduct = null;
		for (Producto product : product_list) {
			if (product.getProduct_id() == product_id) {
				if (product_name != null) product.setProduct_name(product_name);
				if (product_img != null) product.setProduct_img(product_img);
				if (product_cost != null) product.setProduct_cost(product_cost.doubleValue());
				if (product_status != null) product.setProduct_status(product_status);
				if (product_description != null) product.setProduct_description(product_description);
				if (product_rate != null) product.setProduct_rate(product_rate.intValue());
				if (product_category != null) product.setProduct_category(product_category.intValue());
				tmpProduct = product;
				break;
			} // if
		} // foreach
		return tmpProduct;
	} // updateProduct
	
} // class productoServices