package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.ADAHistorialRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.BTCHistorialRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dao.LRCHistorialRepository;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.CoinHistorial;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.ADAHistorialEntity;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.BTCHistorialEntity;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.CoinHistorialEntity;
import com.pruebatecnicaomar.PruebaTecnicaOmar.model.LRCHistorialEntity;

@Service
public class HistorialServiceImpl implements HistorialService{

	private static final long MINTOMILISEGUNDOS= 6000;
	
	@Autowired
	private ADAHistorialRepository adaHistorialRepo;
	
	@Autowired
	private BTCHistorialRepository btcHistorialRepo;
	
	@Autowired
	private LRCHistorialRepository lrcHistorialRepo;
	
	private ModelMapper mapper = new ModelMapper();
	
	@Override
	public List<CoinHistorial> getHistorialBTC(int ultimosMinutos) {
		List<BTCHistorialEntity> btcHisto = btcHistorialRepo.findByIdGreaterThan(Long.valueOf(System.currentTimeMillis() - (ultimosMinutos*MINTOMILISEGUNDOS)));
		
		return transformarBTC(btcHisto);
	}

	@Override
	public List<CoinHistorial> getHistorialLRC(int ultimosMinutos) {
		List<LRCHistorialEntity> lrcHisto = lrcHistorialRepo.findByIdGreaterThan(Long.valueOf(System.currentTimeMillis() - (ultimosMinutos*MINTOMILISEGUNDOS)));
		
		return transformarLRC(lrcHisto);
	}

	@Override
	public List<CoinHistorial> getHistorialADA(int ultimosMinutos) {
		List<ADAHistorialEntity> adaHisto = adaHistorialRepo.findByIdGreaterThan(Long.valueOf(System.currentTimeMillis() - (ultimosMinutos*MINTOMILISEGUNDOS)));
		
		return transformarADA(adaHisto);
	}
	
	private List<CoinHistorial> transformarBTC(List<BTCHistorialEntity> historial){
		List<CoinHistorial> listaCoinHistorial = new ArrayList<>();
		
		for(CoinHistorialEntity ent : historial) {
			listaCoinHistorial.add(new CoinHistorial(ent.getId(), ent.getFecha(), mapper.map(ent.getMoneda(),Criptomoneda.class)));
		}
		
		return listaCoinHistorial;
	}
	
	private List<CoinHistorial> transformarLRC(List<LRCHistorialEntity> historial){
		List<CoinHistorial> listaCoinHistorial = new ArrayList<>();
		
		for(CoinHistorialEntity ent : historial) {
			listaCoinHistorial.add(new CoinHistorial(ent.getId(), ent.getFecha(), mapper.map(ent.getMoneda(),Criptomoneda.class)));
		}
		
		return listaCoinHistorial;
	}
	
	private List<CoinHistorial> transformarADA(List<ADAHistorialEntity> historial){
		List<CoinHistorial> listaCoinHistorial = new ArrayList<>();
		
		for(CoinHistorialEntity ent : historial) {
			listaCoinHistorial.add(new CoinHistorial(ent.getId(), ent.getFecha(), mapper.map(ent.getMoneda(),Criptomoneda.class)));
		}
		
		return listaCoinHistorial;
	}

}
