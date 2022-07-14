package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.maderacnc.MaderaCNC.models.Producto;
import com.maderacnc.MaderaCNC.services.ProductoServices;

@RestController
@RequestMapping (path="/api/products/")
@CrossOrigin(origins = "*")
public class ProductoController {
	
	// Variable de instancia del categoriaServices
	private final ProductoServices ProductoServices;
	
	@Autowired
	public ProductoController (ProductoServices ProductoServices) {
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
			@RequestBody Producto producto 
	) {
		return ProductoServices.updateProduct (
				product_id, 
				producto.getProduct_name(), 
				producto.getProduct_img(), 
				producto.getProduct_cost(), 
				producto.getProduct_status(), 
				producto.getProduct_description(), 
				producto.getProduct_rate(),
				producto.getProduct_category()
		);
	} // updateProduct
	
//	@PutMapping (path="{prodId}")
//	public Producto updateProduct (
//			@PathVariable("prodId") Long product_id,
//			@RequestParam(required = false) String product_name,
//			@RequestParam(required = false) String product_img,
//			@RequestParam(required = false) Double product_cost,
//			@RequestParam(required = false) String product_status,
//			@RequestParam(required = false) String product_description,
//			@RequestParam(required = false) Integer product_rate,
//			@RequestParam(required = false) Integer product_category
//	) {
//		return ProductoServices.updateProduct (
//				product_id, 
//				product_name, 
//				product_img, 
//				product_cost, 
//				product_status, 
//				product_description, 
//				product_rate,
//				product_category
//		);
//	} // updateProduct

} // ProductoController