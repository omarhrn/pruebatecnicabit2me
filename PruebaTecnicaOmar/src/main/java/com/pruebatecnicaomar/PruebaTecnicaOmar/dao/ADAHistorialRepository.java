package com.pruebatecnicaomar.PruebaTecnicaOmar.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnicaomar.PruebaTecnicaOmar.model.ADAHistorialEntity;

@Repository
public interface ADAHistorialRepository extends MongoRepository<ADAHistorialEntity, Long>{
	//El ID son milisegundos del instante en el que se guarda en base de datos
	public List<ADAHistorialEntity> findByIdGreaterThan(Long milisegundos);
}
