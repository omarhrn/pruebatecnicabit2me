package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import java.util.List;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.CoinHistorial;

public interface HistorialService {

	public List<CoinHistorial> getHistorialBTC(int ultimosMinutos);
	public List<CoinHistorial> getHistorialLRC(int ultimosMinutos);
	public List<CoinHistorial> getHistorialADA(int ultimosMinutos);
}
