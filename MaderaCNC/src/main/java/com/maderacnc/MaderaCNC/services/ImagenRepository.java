package com.maderacnc.MaderaCNC.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maderacnc.MaderaCNC.models.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Long>{
	@Query("SELECT i FROM Imagen i WHERE i.id_imagen = ?1")
	Optional<Imagen> findById(String id_img);
}
