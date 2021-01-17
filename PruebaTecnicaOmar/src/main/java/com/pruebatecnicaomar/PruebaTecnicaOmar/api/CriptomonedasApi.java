package com.pruebatecnicaomar.PruebaTecnicaOmar.api;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;

public interface CriptomonedasApi {
	public Criptomoneda getPrecioCriptomonedaByNombre(String nombreCriptomoneda);
}
