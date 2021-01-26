package com.pruebatecnicaomar.PruebaTecnicaOmar.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historialBTC")
public class BTCHistorialEntity extends CoinHistorialEntity{

	public BTCHistorialEntity() {
		super();
	};
	
	public BTCHistorialEntity(Long id, Date fecha, CriptomonedaEntity moneda) {
		super(id, fecha, moneda);
	};
}
