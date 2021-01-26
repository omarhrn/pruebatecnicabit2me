package com.pruebatecnicaomar.PruebaTecnicaOmar.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "historialLRC")
public class LRCHistorialEntity extends CoinHistorialEntity{
	public LRCHistorialEntity() {
		super();
	};
	
	public LRCHistorialEntity(Long id, Date fecha, CriptomonedaEntity moneda) {
		super(id, fecha, moneda);
	};
}
