package com.maderacnc.MaderaCNC.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maderacnc.MaderaCNC.models.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	@Query("SELECT d FROM Direccion d WHERE d.calle = ?1")
	Optional<Direccion> findByCalle(String calle);
}
