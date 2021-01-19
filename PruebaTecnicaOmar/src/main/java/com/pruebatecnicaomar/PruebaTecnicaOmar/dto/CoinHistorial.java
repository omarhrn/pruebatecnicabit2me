package com.pruebatecnicaomar.PruebaTecnicaOmar.dto;

import java.util.Date;

import lombok.Data;

@Data
public class CoinHistorial {
	private Long id;
	private Date fecha;
	private Criptomoneda moneda;
	
	public CoinHistorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoinHistorial(Long id, Date fecha, Criptomoneda moneda) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.moneda = moneda;
	}
	
	
}
