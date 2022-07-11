package com.maderacnc.MaderaCNC.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

import com.maderacnc.MaderaCNC.models.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	@Query("SELECT p FROM Categoria p WHERE p.category_name = ?1")
	Optional<Categoria> findByNombre(String category_name);

}
