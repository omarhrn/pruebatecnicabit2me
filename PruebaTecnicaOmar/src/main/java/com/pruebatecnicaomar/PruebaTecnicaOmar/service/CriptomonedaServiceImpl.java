package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import java.util.Date;
import java.util.TimeZone;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.ADAHistorialRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.BTCHistorialRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.CriptomonedaRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.LRCHistorialRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.ADAHistorialEntity;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.BTCHistorialEntity;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.CriptomonedaEntity;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.LRCHistorialEntity;

@Service
public class CriptomonedaServiceImpl implements CriptomonedaService {

	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private CriptomonedaRepository criptomonedaRepo;
	
	@Autowired
	private ADAHistorialRepository adaHistorialRepo;
	@Autowired
	private BTCHistorialRepository btcHistorialRepo;
	@Autowired
	private LRCHistorialRepository lrcHistorialRepo;
	
	@Override
	public void guardarCriptomoneda(Criptomoneda criptomoneda) {
		if (criptomonedaRepo.existsById(criptomoneda.getId())) {
			
			//Convertir fecha a zona local
			criptomoneda.setUltimaActualizacion(
					new Date(criptomoneda.getUltimaActualizacion().getTime()
							+ TimeZone.getDefault().getOffset(System.currentTimeMillis())));
			
			CriptomonedaEntity criptomonedaEntity = mapper.map(criptomoneda, CriptomonedaEntity.class);
			
			//Actualizamos el precio
			criptomonedaRepo.save(criptomonedaEntity);
			
			Date fecha = new Date();
			//Guardamos en el historial
			switch (criptomoneda.getSimbolo()) {
			case "ADA":
				adaHistorialRepo.insert( new ADAHistorialEntity(criptomonedaEntity.getUltimaActualizacion().getTime(), criptomonedaEntity.getUltimaActualizacion(), criptomonedaEntity));
				break;
			case "BTC":
				btcHistorialRepo.insert(new BTCHistorialEntity(criptomonedaEntity.getUltimaActualizacion().getTime(), criptomonedaEntity.getUltimaActualizacion(), criptomonedaEntity));
				break;
			case "LRC":
				lrcHistorialRepo.insert( new LRCHistorialEntity(criptomonedaEntity.getUltimaActualizacion().getTime(), criptomonedaEntity.getUltimaActualizacion(), criptomonedaEntity));
				break;
			default:
				break;
			}
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
