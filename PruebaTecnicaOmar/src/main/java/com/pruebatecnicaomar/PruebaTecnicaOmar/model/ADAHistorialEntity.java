package com.pruebatecnicaomar.PruebaTecnicaOmar.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historialADA")
public class ADAHistorialEntity extends CoinHistorialEntity {

	public ADAHistorialEntity() {
		super();
	};
	
	public ADAHistorialEntity(Long id, Date fecha, CriptomonedaEntity moneda) {
		super(id, fecha, moneda);
	};
}
