package com.maderacnc.MaderaCNC.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.maderacnc.MaderaCNC.models.Producto;

@Service
public class ProductoServices {
	private final ProductoRepository productoRepository;

	
	
	public ProductoServices(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}//constructor

	public List<Producto> getProducts () {
		return productoRepository.findAll();
	} // getProducts
	
	public Producto getProduct (Long id) {
		return productoRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El producto con el id [" + id + "] no existe.")
		);
	} // getProduct
	
	public Producto deleteProduct (Long id) {
		Producto tmpProduct = null;
			if (productoRepository.existsById(id)) {
				tmpProduct = productoRepository.findById(id).get();
				productoRepository.deleteById(id);
			} // if
		return tmpProduct;
	} // deleteProduct

	public Producto addProduct (Producto product) {
		Producto tmpProduct = null;
		Optional<Producto> prodByName=productoRepository.findByNombre(product.getProduct_name());
		if (prodByName.isPresent()) {
			throw new IllegalArgumentException("El producto con el nombre [" + product.getProduct_name() + "] ya existe.");
		} else {
			productoRepository.save(product);
			tmpProduct = product;
		}
		return tmpProduct;
	} // addProduct

	public Producto updateProduct (Long product_id, String product_name, String product_img, Double product_cost,
			String product_status, String product_description, Integer product_rate, Integer product_category) {
		Producto tmpProduct = null;
			if (productoRepository.existsById(product_id)) {
				tmpProduct = productoRepository.findById(product_id).get();
				if (product_name != null) tmpProduct.setProduct_name(product_name);
				if (product_img != null) tmpProduct.setProduct_img(product_img);
				if (product_cost != null) tmpProduct.setProduct_cost(product_cost.doubleValue());
				if (product_status != null) tmpProduct.setProduct_status(product_status);
				if (product_description != null) tmpProduct.setProduct_description(product_description);
				if (product_rate != null) tmpProduct.setProduct_rate(product_rate);
				if (product_category != null) tmpProduct.setProduct_category(product_category);
				productoRepository.save(tmpProduct);
		} else {
			System.out.println("El producto con el id "+product_id+ " no existe");
		}
			// if
		return tmpProduct;
	} // updateProduct
	
} // class productoServices