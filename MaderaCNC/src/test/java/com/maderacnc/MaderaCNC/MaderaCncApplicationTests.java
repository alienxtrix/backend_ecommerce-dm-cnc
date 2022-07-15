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

@SpringBootTest
@AutoConfigureMockMvc
class MaderaCncApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void pruebaPOST() throws Exception{
		Producto producto = new Producto();
		producto.setProduct_name("");
		producto.setProduct_img(null);
		producto.setProduct_cost(0);
		producto.setProduct_status(null);
		producto.setProduct_description(null);
		producto.setProduct_rate(0);
		producto.setProduct_category(0);
		
		this.mockMvc.perform(post("/api/products/")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJsonString(producto))
		)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Cuaderno italiana doble raya")));
	}// pruebaPOST
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);}//catch
	} // asJsonString
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaDELETE() throws Exception{
		this.mockMvc.perform(delete("/api/products/5"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Cuaderno italiana doble raya")));
	}// pruebaDELETE
	
	@Test
	public void pruebaPUT() throws Exception{
		this.mockMvc.perform(put("/api/products/2").queryParam("nombre", ""))
		//.header("Authorization", "Bearer: Token")
		.andDo(print())
		.andExpect( status().isOk() )
		.andExpect( content().string(containsString("super borrador")));
	}// pruebaPUT
	
	@Test
	@Disabled("Se validará posteriormente")
	public void prueba404() throws Exception{
		this.mockMvc.perform(get("/api/products/2"))
		.andDo(print())
		.andExpect( status().is5xxServerError());
	}// prueba404
	
	@Test
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/products/2"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Borrador")));
	}// pruebaGET

}
