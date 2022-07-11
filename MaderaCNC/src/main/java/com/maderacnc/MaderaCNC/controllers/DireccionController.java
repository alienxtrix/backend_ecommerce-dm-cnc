package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.maderacnc.MaderaCNC.models.Direccion;
import com.maderacnc.MaderaCNC.services.DireccionServices;

@RestController
@RequestMapping(path="/api/addresses/")
//@CrossOrigin(origins = "*")
public class DireccionController {

		private final DireccionServices direccionServices;
		
		@Autowired
		public DireccionController (DireccionServices direccionServices) {
			this.direccionServices = direccionServices;
		} // Constructor
		
		@GetMapping
		public List<Direccion> getDirecciones () {
			return direccionServices.getDirecciones();
		} // getDirecciones
		
		@GetMapping (path="{dirId}")
		public Direccion getDir (@PathVariable("dirId") Long id) {
			return direccionServices.getDir(id);
		} // getProduct
		
		@DeleteMapping (path="{dirId}")
		public Direccion deleteDir (@PathVariable("dirId") Long id) {
			return direccionServices.deleteDir(id);
		} // deleteDir
		
		@PostMapping
		public Direccion addDir (@RequestBody Direccion direccion) {
			return direccionServices.addDir(direccion);
		} // addDir

		@PutMapping (path="{dirId}")
		public Direccion updateDireccion (
				@PathVariable("dirId") Long id_direccion,
				@RequestParam(required = false) String calle,
				@RequestParam(required = false) String numero,
				@RequestParam(required = false) String colonia,
				@RequestParam(required = false) Integer cp,
				@RequestParam(required = false) String ciudad,
				@RequestParam(required = false) String estado,
				@RequestParam(required = false) String referencia
				) 
		{
			return direccionServices.updateDir (
					id_direccion, 
					calle, 
					numero, 
					colonia, 
					cp, 
					ciudad, 
					estado,
					referencia
					);
			} // updateDireccion
}// class DireccionController
