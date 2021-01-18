package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;

public interface CriptomonedaService {
	public void guardarCriptomoneda(Criptomoneda criptomoneda);
	public Criptomoneda getCriptomoneda(int id);
	public Criptomoneda getCriptomonedaByNombre(String nombre);
	
}
