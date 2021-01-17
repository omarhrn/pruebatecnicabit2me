package com.pruebatecnicaomar.PruebaTecnicaOmar.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Root;

@RestController
public class CriptomonedasApiImpl implements CriptomonedasApi{

	private static final String SYMBOLSCOINS = "BTC,LRC,ADA";
	private static final int	RES_OK		 = 0;
	
	private List<Criptomoneda> listaCriptomonedas = new ArrayList<>();
	
	@Override
	@GetMapping(value="/getPrecioCriptomonedaByNombre")
	public Criptomoneda getPrecioCriptomonedaByNombre(@RequestParam String nombreCriptomoneda) {
		
		Root resultadoLlamadaCoinmarket = CoinmarketcapApi.coinmarketcapInfoCoins(SYMBOLSCOINS);
		
		listaCriptomonedas = obtenerListaCriptomonedas(resultadoLlamadaCoinmarket);
		
		for (Criptomoneda aux : listaCriptomonedas) {
			if(aux.getNombre().equalsIgnoreCase(nombreCriptomoneda)) {
				return aux;
			}
		}
		return null;
	}

	private List<Criptomoneda> obtenerListaCriptomonedas(Root resultado){
		
		List<Criptomoneda> aux = new ArrayList<>();
		
		if(resultado.getStatus().getError_code() == RES_OK) {
			
			aux.add(new Criptomoneda(resultado.getData().getBTC().getId(), 
					resultado.getData().getBTC().getName(), 
					resultado.getData().getBTC().getQuote().getUSD().getPrice(), 
					resultado.getData().getBTC().getSymbol()));
			
			aux.add(new Criptomoneda(resultado.getData().getLRC().getId(), 
					resultado.getData().getLRC().getName(), 
					resultado.getData().getLRC().getQuote().getUSD().getPrice(), 
					resultado.getData().getLRC().getSymbol()));
			
			aux.add(new Criptomoneda(resultado.getData().getADA().getId(), 
					resultado.getData().getADA().getName(), 
					resultado.getData().getADA().getQuote().getUSD().getPrice(), 
					resultado.getData().getADA().getSymbol()));
		}
		
		return aux;
	}
}
