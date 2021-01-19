package com.pruebatecnicaomar.PruebaTecnicaOmar.api;

import java.util.List;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.CoinHistorial;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Root;

public interface CriptomonedasApi {
	public Criptomoneda getPrecioCriptomonedaByNombre(String nombreCriptomoneda);
	public List<CoinHistorial> getHistorial(String simbolo, int ultimosMinutos);
	public Root actualizaMonedas();
}
