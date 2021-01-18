package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.CriptomonedaRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.CriptomonedaEntity;

@Service
public class CriptomonedaServiceImpl implements CriptomonedaService {

	
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private CriptomonedaRepository criptomonedaRepo;
	
	@Override
	public void guardarCriptomoneda(Criptomoneda criptomoneda) {
		if (criptomonedaRepo.existsById(criptomoneda.getId())) {
			//Actualizamos el precio
			criptomonedaRepo.save(mapper.map(criptomoneda, CriptomonedaEntity.class));
			//Guardamos en el historial
			
		}else {
			//Caso especial lo insertamos
			criptomonedaRepo.insert(mapper.map(criptomoneda, CriptomonedaEntity.class));
		}
		
	}

	@Override
	public Criptomoneda getCriptomoneda(int id) {
		return mapper.map(criptomonedaRepo.findById(Integer.valueOf(id)).get(),Criptomoneda.class);
	}

	@Override
	public Criptomoneda getCriptomonedaByNombre(String nombre) {
		return mapper.map(criptomonedaRepo.findByNombre(formatNombre(nombre)),Criptomoneda.class);
	}

	private String formatNombre(String nombre) {
		return nombre.toLowerCase().replaceFirst(nombre.substring(0, 1).toLowerCase(), nombre.substring(0, 1).toUpperCase());
	}
}
