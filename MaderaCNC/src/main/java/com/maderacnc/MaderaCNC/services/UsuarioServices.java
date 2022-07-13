package com.maderacnc.MaderaCNC.services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import com.maderacnc.MaderaCNC.models.Usuario;

@Service
public class UsuarioServices {
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServices(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}//constructor

	public List<Usuario> getUsers (){
		return usuarioRepository.findAll();
	} // getUsers
	
	public Usuario getUser (Long id) {
		return usuarioRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El nombre con el id [" + id + "] no existe.")
		);
	} // getUsers
	
	public Usuario deleteUser (Long id) {
		Usuario tmpUser = null;
			if (usuarioRepository.existsById(id)) {
				tmpUser = usuarioRepository.findById(id).get();
				usuarioRepository.deleteById(id);
			} // if
	return tmpUser;
	} // deleteUser
	
	public Usuario addUser (Usuario user) {
		Usuario tmpUser = null;
		Optional<Usuario> prodByName=usuarioRepository.findByEmail(user.getUser_email());
		if (prodByName.isPresent()) {
			throw new IllegalArgumentException("Este email [" + user.getUser_email() + "] ya existe.");
		} else {
			usuarioRepository.save(user);
			tmpUser = user;
		}
		return tmpUser;
	} // addUser
	
	public Usuario updateUser (Long user_id, String user_name, String user_lastNF, String user_lastNM, String user_date, String user_pass, String user_phone, String user_email, Integer userType_id) {
		Usuario tmpUser = null;
			if(usuarioRepository.existsById(user_id)) {
				tmpUser=usuarioRepository.findById(user_id).get();
				if (user_name != null) tmpUser.setUser_name(user_name);
				if (user_lastNF != null) tmpUser.setUser_lastNF(user_lastNF);
				if (user_lastNM != null) tmpUser.setUser_lastNM(user_lastNM);
				if (user_date != null) tmpUser.setUseR_date(user_date);
				if (user_pass != null) tmpUser.setUser_pass(user_pass);
				if (user_phone != null) tmpUser.setUser_phone(user_phone);
				if (user_email != null) tmpUser.setUser_email(user_email);
				if (userType_id != null) tmpUser.setUserType_id(userType_id);
				usuarioRepository.save(tmpUser);
		} else {
			System.out.println("El nombre con el id "+user_id+ " no existe");
		}
		return tmpUser;
	}//updateUser
	
	// ---------- LOGIN ----------
	
	@PostMapping
	public String loginUser (String user_email, String user_pass) {
		Optional<Usuario> prodByEmail=usuarioRepository.findByEmail(user_email);
		String tmpUser = "Correo y/o contraseña incorrectos.";
		if(prodByEmail.isPresent()) {
			if(prodByEmail.get().getUser_pass().equals(user_pass)) {
				tmpUser = prodByEmail.get().getUser_name() + " " + prodByEmail.get().getUser_lastNF() + " " + prodByEmail.get().getUser_lastNM();
				tmpUser = "\n Bienvenid@ " + tmpUser + ", se iniciï¿½ sesiï¿½n de manera correcta.";
			}
		} else {
		throw new IllegalArgumentException("El usuario con el email [" + user_email + "] no existe.");
		}
		return tmpUser;
	}
	public boolean validateUsuario(Usuario usuario) {
		boolean res= false;
	 	Optional<Usuario> userByUsername = usuarioRepository.findByNombre(usuario.getUser_name());
	 	if(userByUsername.isPresent()) {
	 		Usuario u =userByUsername.get();
	 		if (u.getUser_pass().equals(usuario.getUser_pass())) {
	 			res = true;
	 		}
	 	}
		return res;
	}
	
}