package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.maderacnc.MaderaCNC.models.Usuario;
import com.maderacnc.MaderaCNC.services.UsuarioServices;

@RestController
@RequestMapping(path="/api/users/")
//@CrossOrigin(origins = "*")
public class UsuarioController {
	
	// Variable de instancia del usuarioServices
	private final UsuarioServices usuarioServices;
	
	@Autowired
	public UsuarioController (com.maderacnc.MaderaCNC.services.UsuarioServices UsuarioServices) {
		this.usuarioServices = UsuarioServices;
	} // Constructor

	@GetMapping
	public List<Usuario> getAllUsers () {
		return usuarioServices.getUsers();
	} // getAllUsers
	
	@GetMapping (path = "{userId}")
	public Usuario getUser (@PathVariable("userId") Long user_id) {
		return usuarioServices.getUser(user_id);
	} // getUser
	
	@DeleteMapping (path = "{userId}")
	public Usuario deleteUser (@PathVariable("userId") Long user_id) {
		return usuarioServices.deleteUser(user_id);
	} // deleteUser
	
	@PostMapping
	public Usuario addUser (@RequestBody Usuario user) {
		return usuarioServices.addUser(user);
	} // addUser
	
	@PutMapping(path="{userId}")
	public Usuario updateUser (@PathVariable("userId") Long user_id,
			@RequestParam (required = false) String user_name,
			@RequestParam (required = false) String user_lastNF,
			@RequestParam (required = false) String user_lastNM,
			@RequestParam (required = false) String user_date,
			@RequestParam (required = false) String user_pass,
			@RequestParam (required = false) String user_phone,
			@RequestParam (required = false) String user_email,
			@RequestParam (required = false) Integer userType_id
			){
		return usuarioServices.updateUser(user_id, user_name, user_lastNF, user_lastNM, user_date, user_pass, user_phone, user_email, userType_id);
	} // updateUser
	
} // class UsuarioController