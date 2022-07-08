package com.maderacnc.MaderaCNC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maderacnc.MaderaCNC.Usuario;
import com.maderacnc.MaderaCNC.services.UsuarioServices;

@RestController
@RequestMapping(path="/api/login/")
@CrossOrigin(origins = "*")
public class LoginController {

	// Variable de instancia del usuarioServices
	private final UsuarioServices usuarioServices;

	@Autowired
	public LoginController (UsuarioServices usuarioServices) {
		super();
		this.usuarioServices = usuarioServices;
	} // Constructor
	
	@PostMapping
	public String loginUser (@RequestParam("user_email") String user_email, @RequestParam("user_pass") String user_pass) {
		return usuarioServices.loginUser(user_email, user_pass);
	} // loginUser
	
} // class LoginController