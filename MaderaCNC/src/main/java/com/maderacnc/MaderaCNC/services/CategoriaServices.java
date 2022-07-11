package com.maderacnc.MaderaCNC.services;


import java.util.List;
import org.springframework.stereotype.Service;
import com.maderacnc.MaderaCNC.models.Categoria;

@Service
public class CategoriaServices {
	private final CategoriaRepository categoriaRepository;

	public CategoriaServices(CategoriaRepository categoriaRepository) {
		super();
		this.categoriaRepository = categoriaRepository;
	}//constructor

	public List<Categoria> getCategories () {
		return categoriaRepository.findAll();
	} // getCategories

	public Categoria getCategory (Long id) {
		return categoriaRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("La categoria con el id [" + id + "] no existe.")
		);
	} // getCategory
	
} // class categoriaServices