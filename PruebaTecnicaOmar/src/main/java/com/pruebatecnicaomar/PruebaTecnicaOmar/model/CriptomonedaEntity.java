package com.pruebatecnicaomar.PruebaTecnicaOmar.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "criptomonedas")
public class CriptomonedaEntity {

	@Id
	private int id;
	private String nombre;
	private double precio;
	private String simbolo;
	private Date ultimaActualizacion;
	
	
	public CriptomonedaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CriptomonedaEntity(int id, String nombre, double precio, String simbolo, Date ultimaActualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.simbolo = simbolo;
		this.ultimaActualizacion = ultimaActualizacion;
	}
}
