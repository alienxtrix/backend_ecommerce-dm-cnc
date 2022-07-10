package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import com.maderacnc.MaderaCNC.models.Categoria;
import com.maderacnc.MaderaCNC.services.CategoriaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path="/api/categories/")
@CrossOrigin(origins = "*")
public class CategoriaController {

	// Variable de instancia del categoriaServices
	private final CategoriaServices CategoriaServices;
	
	@Autowired
	public CategoriaController (com.maderacnc.MaderaCNC.services.CategoriaServices CategoriaServices) {
		this.CategoriaServices = CategoriaServices;
	}
	
	@GetMapping
	public List<Categoria> getAllCategories () {
		return CategoriaServices.getCategories();
	} // getAllProducts
	
	@GetMapping (path="{prodId}")
	public Categoria getCategory (@PathVariable("prodId") Long id) {
		return CategoriaServices.getCategory(id);
	} // getProduct
	
} // class CategoriaController