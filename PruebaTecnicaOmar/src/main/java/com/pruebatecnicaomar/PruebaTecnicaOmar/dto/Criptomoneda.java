package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import lombok.Data;

@Data
public class Criptomoneda {

	private int id;
	private String nombre;
	private double precio;
	private String simbolo;
	
	public Criptomoneda(int id, String nombre, double precio, String simbolo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.simbolo = simbolo;
	}

	public Criptomoneda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
