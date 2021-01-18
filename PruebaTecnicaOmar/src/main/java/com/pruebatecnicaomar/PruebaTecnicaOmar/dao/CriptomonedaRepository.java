package com.pruebatecnicaomar.PruebaTecnicaOmar.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnicaomar.PruebaTecnicaOmar.model.CriptomonedaEntity;

@Repository
public interface CriptomonedaRepository extends MongoRepository<CriptomonedaEntity, Integer>{
	
	public CriptomonedaEntity findByNombre(String nomnbre);

}
