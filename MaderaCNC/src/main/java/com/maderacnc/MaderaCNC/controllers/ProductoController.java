package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maderacnc.MaderaCNC.Producto;
import com.maderacnc.MaderaCNC.services.ProductoServices;

@RestController
@RequestMapping (path="/api/products/")
@CrossOrigin(origins = "*")
public class ProductoController {
	
	// Variable de instancia del categoriaServices
	private final ProductoServices ProductoServices;
	
	@Autowired
	public ProductoController (com.maderacnc.MaderaCNC.services.ProductoServices ProductoServices) {
		this.ProductoServices = ProductoServices;
	} // Constructor
	
	@GetMapping
	public List<Producto> getAllProducts () {
		return ProductoServices.getProducts();
	} // getAllProducts
	
	@GetMapping (path="{prodId}")
	public Producto getProduct (@PathVariable("prodId") Long id) {
		return ProductoServices.getProduct(id);
	} // getProduct
	
	@DeleteMapping (path="{prodId}")
	public Producto deleteProduct (@PathVariable("prodId") Long id) {
		return ProductoServices.deleteProduct(id);
	} // deleteProduct
	
	@PostMapping
	public Producto addProduct (@RequestBody Producto product) {
		return ProductoServices.addProduct(product);
	} // addProduct

	@PutMapping (path="{prodId}")
	public Producto updateProduct (
			@PathVariable("prodId") Long product_id,
			@RequestParam(required = false) String product_name,
			@RequestParam(required = false) String product_img,
			@RequestParam(required = false) Double product_cost,
			@RequestParam(required = false) String product_status,
			@RequestParam(required = false) String product_description,
			@RequestParam(required = false) Integer product_rate,
			@RequestParam(required = false) Integer product_category
	) {
		return ProductoServices.updateProduct (
				product_id, 
				product_name, 
				product_img, 
				product_cost, 
				product_status, 
				product_description, 
				product_rate,
				product_category
		);
	} // updateProduct

} // ProductoController