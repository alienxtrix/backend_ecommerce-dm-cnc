package com.maderacnc.MaderaCNC.controllers;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.maderacnc.MaderaCNC.jwt.config.JwtFilter;
import com.maderacnc.MaderaCNC.models.Token;
import com.maderacnc.MaderaCNC.models.Usuario;
import com.maderacnc.MaderaCNC.services.UsuarioServices;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
//@CrossOrigin(origins = "*")
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
	@PostMapping
	public Token login(@RequestBody Usuario usuario) throws ServletException {
		if(usuarioServices.validateUsuario(usuario)) {
			return new Token(generateToken(usuario.getUser_name()));
		}
		throw new ServletException("Nombre de usuario o contraseña incorrectos.");
	}
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, 10);
		return Jwts.builder().setSubject(username).claim("role", "user")
				.setIssuedAt(new Date()).setExpiration(calendar.getTime())
				.signWith(SignatureAlgorithm.HS256, JwtFilter.secret).compact();
	}
} // class LoginController