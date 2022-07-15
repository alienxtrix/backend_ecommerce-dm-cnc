package com.maderacnc.MaderaCNC.controllers;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maderacnc.MaderaCNC.models.Login;
import com.maderacnc.MaderaCNC.jwt.config.JwtFilter;
import com.maderacnc.MaderaCNC.models.Token;
import com.maderacnc.MaderaCNC.services.UsuarioServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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
	public Token login(@RequestBody Login login) throws ServletException {
		if(usuarioServices.validateUsuario(login) == 2) {
			return new Token(generateToken(login.getUser_email()));
		}
		else if(usuarioServices.validateUsuario(login) == 1) {
			return new Token("1");
		}
		
		throw new ServletException("Nombre de usuario o contraseņa incorrectos.");
	}
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}
} // class LoginController