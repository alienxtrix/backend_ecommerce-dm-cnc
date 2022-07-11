package com.maderacnc.MaderaCNC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.maderacnc.MaderaCNC.models.Imagen;
import com.maderacnc.MaderaCNC.services.ImagenServices;

@RestController
@RequestMapping(path="/api/imagen/")
//@CrossOrigin(origins = "*")
public class ImagenController {
	
	private final ImagenServices imagenServices;
	
	@Autowired
	public ImagenController (com.maderacnc.MaderaCNC.services.ImagenServices imagenServices) {
		this.imagenServices = imagenServices;
	} // Constructor
	
	@GetMapping
	public List<Imagen> getImagenes () {
		return imagenServices.getImagenes();
	} // getImagenes
	
	@GetMapping (path="{imgId}")
	public Imagen getImg (@PathVariable("imgId") Long id) {
		return imagenServices.getImagen(id);
	} // getImagen
	
	@DeleteMapping (path="{imgId}")
	public Imagen deleteDir (@PathVariable("imgId") Long id) {
		return imagenServices.deleteImg(id);
	} // deleteImg
	
	@PostMapping
	public Imagen addDir (@RequestBody Imagen imagen) {
		return imagenServices.addImg(imagen);
	} // addImg

	@PutMapping (path="{imgId}")
	public Imagen updateImg (
			@PathVariable("imgId") Long id_imagen,
			@RequestParam(required = false) String img,
			@RequestParam(required = false) Integer product_id
			) 
	{
		return imagenServices.updateImg (
				id_imagen, 
				img, 
				product_id
				);
		} // updateImg
}
