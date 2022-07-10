package com.maderacnc.MaderaCNC.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maderacnc.MaderaCNC.models.Usuario;

@Service
public class UsuarioServices {
	
	public final ArrayList<Usuario> user_list = new ArrayList<Usuario>();
	
	public UsuarioServices() {
		user_list.add(new Usuario("Marihan Itzel", "Bernal", "Flores", "22-10-1999", "Onedirection", "4521122757", "marihan.bernal@gmail.com"));
		user_list.add(new Usuario("Eduardo", "Victoria", "Sanchez", "20-09-1999", "Paswword", "9612294249", "eduardo.mvisa@gmail.com"));
	}
	
	public ArrayList<Usuario> getUsers (){
		return user_list;
	} // getUsers
	
	public Usuario getUser (Long user_id) {
		Usuario tmpUser = null;
		for (Usuario user : user_list) {
			if(user.getUser_id() == user_id) {
				tmpUser = user;
				break;
			}
		}
		return tmpUser;
	} // getUsers
	
	public Usuario deleteUser (Long user_id) {
		Usuario tmpUser = null;
		for (Usuario user : user_list) {
			if(user.getUser_id() == user_id) {
				tmpUser = user_list.remove(user_list.indexOf(user));
				break;
			}
		}
		return tmpUser;
	} // deleteUser
	
	public Usuario addUser (Usuario user) {
		user_list.add(user);
		return user;
	} // addUser
	
	public Usuario updateUser (Long user_id, String user_name, String user_lastNF, String user_lastNM, String user_date, String user_pass, String user_phone, String user_email) {
		Usuario tmpUser = null;
		for (Usuario user : user_list) {
			if(user.getUser_id() == user_id) {
				if (user_name != null) user.setUser_name(user_name);
				if (user_lastNF != null) user.setUser_lastNF(user_lastNF);
				if (user_lastNM != null) user.setUser_lastNM(user_lastNM);
				if (user_date != null) user.setUseR_date(user_date);
				if (user_pass != null) user.setUser_pass(user_pass);
				if (user_phone != null) user.setUser_phone(user_phone);
				if (user_email != null) user.setUser_email(user_email);
				tmpUser = user;
				break;
			}
		}
		return tmpUser;
	}
	
	// ---------- LOGIN ----------
	
	@PostMapping
	public String loginUser (String user_email, String user_pass) {
		String tmpUser = "Correo y/o contraseña incorrectos.";
		for (Usuario user : user_list) {
			if (user.getUser_email().equals(user_email) && user.getUser_pass().equals(user_pass)) {
				tmpUser = user.getUser_name() + " " + user.getUser_lastNF() + " " + user.getUser_lastNM();
				tmpUser = "\n Bienvenid@  " + tmpUser + ", se inició sesión de manera correcta.";
				break;
			}
		}
		return tmpUser;
	}
	
}