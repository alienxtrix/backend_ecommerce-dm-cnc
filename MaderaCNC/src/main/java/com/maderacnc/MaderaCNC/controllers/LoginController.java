package com.maderacnc.MaderaCNC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maderacnc.MaderaCNC.models.Login;
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
	public String loginUser (@RequestBody Login login) {
		return usuarioServices.loginUser(login);
	} // loginUser
	
} // class LoginController