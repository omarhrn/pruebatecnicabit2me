package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Criptomoneda {

	private int id;
	private String nombre;
	private double precio;
	private String simbolo;
	private Date ultimaActualizacion;
	

	public Criptomoneda() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Criptomoneda(int id, String nombre, double precio, String simbolo, Date ultimaActualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.simbolo = simbolo;
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
}
