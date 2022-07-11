package com.maderacnc.MaderaCNC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maderacnc.MaderaCNC.models.Direccion;

@Service
public class DireccionServices {

	private final DireccionRepository direccionRepository;
	
	public DireccionServices(DireccionRepository direccionRepository) {
		super();
		this.direccionRepository = direccionRepository;
	}//constructor
	
	public List<Direccion> getDirecciones (){
		return direccionRepository.findAll();
	} // getDirecciones
	
	public Direccion getDir (Long id_direccion) {
		return direccionRepository.findById(id_direccion).orElseThrow(
				() -> new IllegalArgumentException("La dirección con el id [" + id_direccion + "] no existe.")
		);
	} // getDir
	
	public Direccion deleteDir (Long id_direccion) {
		Direccion tmpDir = null;
		if (direccionRepository.existsById(id_direccion)) {
			tmpDir = direccionRepository.findById(id_direccion).get();
			direccionRepository.deleteById(id_direccion);
		} // if
	return tmpDir;
	} // deleteDir
	
	public Direccion addDir (Direccion dir) {
		Direccion tmpDir = null;
		direccionRepository.save(dir);
		tmpDir = dir;
		return tmpDir;	
	} // addDir
	
	public Direccion updateDir (Long id_direccion, String calle, String numero, String colonia, Integer cp, String ciudad, String estado, String referencia) {
		Direccion tmpDir = null;
		if(direccionRepository.existsById(id_direccion)) {
			tmpDir = direccionRepository.findById(id_direccion).get();
				if (calle != null) tmpDir.setCalle(calle);
				if (numero != null) tmpDir.setNumero(numero);
				if (colonia != null) tmpDir.setColonia(colonia);
				if (cp != null) tmpDir.setCp(cp);
				if (ciudad != null) tmpDir.setCiudad(ciudad);
				if (estado != null) tmpDir.setEstado(estado);
				if (referencia != null) tmpDir.setReferencia(referencia);
				direccionRepository.save(tmpDir);
			} else {
				System.out.println("La dirección con el id "+id_direccion+ " no existe");
			}
		return tmpDir;
	}// updateDir
	
}// class DireccionServices
