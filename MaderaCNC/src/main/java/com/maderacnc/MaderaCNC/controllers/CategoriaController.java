package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import com.maderacnc.MaderaCNC.models.Categoria;
import com.maderacnc.MaderaCNC.services.CategoriaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path="/api/categories/")
//@CrossOrigin(origins = "*")
public class CategoriaController {

	// Variable de instancia del categoriaServices
	private final CategoriaServices CategoriaServices;
	
	@Autowired
	public CategoriaController (com.maderacnc.MaderaCNC.services.CategoriaServices CategoriaServices) {
		this.CategoriaServices = CategoriaServices;
	}//constructor
	
	@GetMapping
	public List<Categoria> getAllCategories () {
		return CategoriaServices.getCategories();
	} // getAllCategorys
	
	@GetMapping (path="{prodId}")
	public Categoria getCategory (@PathVariable("prodId") Long id) {
		return CategoriaServices.getCategory(id);
	} // getCategory
	
} // class CategoriaController