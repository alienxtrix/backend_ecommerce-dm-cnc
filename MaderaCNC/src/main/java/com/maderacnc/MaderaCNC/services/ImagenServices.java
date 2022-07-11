package com.maderacnc.MaderaCNC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maderacnc.MaderaCNC.models.Imagen;

@Service
public class ImagenServices {

private final ImagenRepository imagenRepository;
	
	public ImagenServices(ImagenRepository imagenRepository) {
		super();
		this.imagenRepository = imagenRepository;
	}//constructor
	
	public List<Imagen> getImagenes (){
		return imagenRepository.findAll();
	} // getImagenes
	
	public Imagen getImagen (Long id_imagen) {
		return imagenRepository.findById(id_imagen).orElseThrow(
				() -> new IllegalArgumentException("La imagen con el id [" + id_imagen + "] no existe.")
		);
	} // getImg
	
	public Imagen deleteImg (Long id_imagen) {
		Imagen tmpImg = null;
			if(imagenRepository.existsById(id_imagen)) {
				tmpImg = imagenRepository.findById(id_imagen).get();
				imagenRepository.deleteById(id_imagen);
			}// if
		return tmpImg;
	} // deleteImg
	
	public Imagen addImg (Imagen img) {
		Imagen tmpImg = null;
		imagenRepository.save(img);
		tmpImg = img;
		return tmpImg;
	} // addImg
	
	public Imagen updateImg (Long id_imagen, String imagen, Integer product_id) {
		Imagen tmpImg = null;
			if(imagenRepository.existsById(id_imagen)) {
				tmpImg = imagenRepository.findById(id_imagen).get();
				if (imagen != null) tmpImg.setImg(imagen);
				if (product_id != null) tmpImg.setProduct_id(product_id);
				imagenRepository.save(tmpImg);
			} else {
				System.out.println("La imagen con el id "+id_imagen+ " no existe");
			}
		return tmpImg;
	}// updateImg
}
