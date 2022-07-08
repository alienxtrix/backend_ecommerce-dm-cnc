package com.maderacnc.MaderaCNC.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import com.maderacnc.MaderaCNC.models.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long>{
	@Query("SELECT p FROM Producto p WHERE p.product_name = ?1")
	Optional<Producto> findByNombre(String product_name);

}
