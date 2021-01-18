package com.pruebatecnicaomar.PruebaTecnicaOmar.api;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Root;

public interface CriptomonedasApi {
	public Criptomoneda getPrecioCriptomonedaByNombre(String nombreCriptomoneda);
	public Root actualizaMonedas();
}
