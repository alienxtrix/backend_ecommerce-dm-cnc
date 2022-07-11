package com.maderacnc.MaderaCNC.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;
import com.maderacnc.MaderaCNC.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT p FROM Usuario p WHERE p.user_name = ?1")
	Optional<Usuario> findByNombre(String user_name);
	@Query("SELECT p FROM Usuario p WHERE p.user_email = ?1")
	Optional<Usuario> findByEmail(String user_email);
}
