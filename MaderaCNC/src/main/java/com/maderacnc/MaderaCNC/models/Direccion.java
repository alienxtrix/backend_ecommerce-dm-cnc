package com.maderacnc.MaderaCNC.models;

import javax.persistence.*;

@Entity
@Table(name="direccion")
public class Direccion {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id_direccion;
	@Column (nullable = false)
	private String calle;
	@Column (nullable = false)
	private String numero;
	private String colonia;
	private int cp;
	@Column (nullable = false)
	private String ciudad;
	@Column (nullable = false)
	private String estado;
	private String referencia;
	public Direccion(Long id_direccion, String calle, String numero, String colonia, int cp, String ciudad, String estado, String referencia) {
		
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.numero = numero;
		this.colonia = colonia;
		this.cp = cp;
		this.ciudad = ciudad;
		this.estado = estado;
		this.referencia = referencia;
		
	}// constructor
	
	public Direccion() {
	}// Constructor Default
	
	public Long getIdDireccion() {
		return id_direccion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@Override
	public String toString() {
		return "Direccion [id_direccion=" + id_direccion + ", calle=" + calle + ", numero=" + numero + ", colonia="
				+ colonia + ", cp=" + cp + ", ciudad=" + ciudad + ", estado=" + estado + ", referencia=" + referencia
				+ "]";
	}// toString

	
} // class Direccion
