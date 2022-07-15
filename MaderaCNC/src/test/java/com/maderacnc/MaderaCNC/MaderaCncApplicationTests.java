package com.maderacnc.MaderaCNC;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maderacnc.MaderaCNC.models.Producto;
import com.maderacnc.MaderaCNC.models.Usuario;

@SpringBootTest
@AutoConfigureMockMvc
class MaderaCncApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);}//catch
	} // asJsonString

//		------ Pruebas Unitarias Productos ------
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaPOST() throws Exception{
		Producto producto = new Producto();
		producto.setProduct_name("Tabla de Pikachu");
		producto.setProduct_img("data:image/png;base64,");
		producto.setProduct_cost(249);
		producto.setProduct_status("Inactivo");
		producto.setProduct_description("Tabla para que pika pikes tu comida");
		producto.setProduct_rate(5);
		producto.setProduct_category(2);
		
		this.mockMvc.perform(post("/api/products/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(producto))
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("pikes")));
	}// pruebaPOST
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaDELETE() throws Exception{
		this.mockMvc.perform(delete("/api/products/3"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Base para cuchillos")));
	}// pruebaDELETE
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaPUT() throws Exception{
		this.mockMvc.perform(put("/api/products/2")
		.queryParam("product_name", "Bandeja en forma de Liebre"))
		.andDo(print())
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("Liebre")));
	}// pruebaPUT
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/products/5"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Porta Vaso")));
	}// pruebaGET
	
//			------ Pruebas Unitarias Usuarios ------
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaUsuarioPOST() throws Exception{
		Usuario usuario = new Usuario();
		usuario.setUser_name("Jean Charles");
		usuario.setUser_lastNF("Valente");
		usuario.setUser_lastNM("Lizaldi");
		usuario.setUseR_date("1997-01-01");
		usuario.setUser_pass("oraucimirituciragnarap");
		usuario.setUser_phone("5544332211");
		usuario.setUser_email("jcvl@gmail.com");
		usuario.setUser_type_id(1);
		
		this.mockMvc.perform(post("/api/users/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(usuario))
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Jean Charles")));
	}// pruebaPOST
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaUsuarioDELETE() throws Exception{
		this.mockMvc.perform(delete("/api/users/8"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Joan")));
	}// pruebaDELETE
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaUsuarioPUT() throws Exception{
		this.mockMvc.perform(put("/api/users/2").queryParam("user_name", "Hosea Luis"))
		//.header("Authorization", "Bearer: Token")
		.andDo(print())
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("Hosea")));
	}// pruebaPUT
	
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	void pruebaUsuarioGET() throws Exception {
		this.mockMvc.perform(get("/api/users/2"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Miguel")));
	}// pruebaGET
	
}
