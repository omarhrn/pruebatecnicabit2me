package com.pruebatecnicaomar.PruebaTecnicaOmar.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class CoinHistorialEntity {
	
	@Id
	private Long id;
	private Date fecha;
	private CriptomonedaEntity moneda;
	
	public CoinHistorialEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoinHistorialEntity(Long id, Date fecha, CriptomonedaEntity moneda) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.moneda = moneda;
	}
	
	
}
