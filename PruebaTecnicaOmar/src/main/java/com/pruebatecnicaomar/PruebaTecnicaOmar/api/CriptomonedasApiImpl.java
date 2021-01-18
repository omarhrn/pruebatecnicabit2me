package com.pruebatecnicaomar.PruebaTecnicaOmar.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Root;
import com.pruebatecnicaomar.PruebaTecnicaOmar.service.CriptomonedaServiceImpl;

@RestController
public class CriptomonedasApiImpl implements CriptomonedasApi{

	private static final String SYMBOLSCOINS = "BTC,LRC,ADA";
	private static final int	RES_OK		 = 0;
	
	
	
	@Autowired
	private CriptomonedaServiceImpl criptomonedaService;
	
	@Override
	@GetMapping(value="/getPrecioCriptomonedaByNombre")
	public Criptomoneda getPrecioCriptomonedaByNombre(@RequestParam String nombreCriptomoneda) {
		Criptomoneda res = null;
		try {
			res = criptomonedaService.getCriptomonedaByNombre(nombreCriptomoneda);
		} catch (Exception e) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Tenemos informacion sobre: Bitcoin, Loopring y Cardano");
		}
		
		return res;
	}
	
	@Override
	@GetMapping(value="/actualizaMonedas")
	public Root actualizaMonedas() {
		Root resultadoLlamadaCoinmarket = CoinmarketcapApi.coinmarketcapInfoCoins(SYMBOLSCOINS);
		
		List<Criptomoneda> listaCriptomonedas = obtenerListaCriptomonedas(resultadoLlamadaCoinmarket);
		
		for (Criptomoneda aux : listaCriptomonedas) {
			criptomonedaService.guardarCriptomoneda(aux);
		}
				
		return resultadoLlamadaCoinmarket;
	}

	private List<Criptomoneda> obtenerListaCriptomonedas(Root resultado){
		
		List<Criptomoneda> aux = new ArrayList<>();
		
		if(resultado.getStatus().getError_code() == RES_OK) {
			aux.add(new Criptomoneda(resultado.getData().getBTC().getId(), 
					resultado.getData().getBTC().getName(), 
					resultado.getData().getBTC().getQuote().getUSD().getPrice(), 
					resultado.getData().getBTC().getSymbol(),
					resultado.getData().getBTC().getLast_updated()));
			
			aux.add(new Criptomoneda(resultado.getData().getLRC().getId(), 
					resultado.getData().getLRC().getName(), 
					resultado.getData().getLRC().getQuote().getUSD().getPrice(), 
					resultado.getData().getLRC().getSymbol(),
					resultado.getData().getLRC().getLast_updated()));
			
			aux.add(new Criptomoneda(resultado.getData().getADA().getId(), 
					resultado.getData().getADA().getName(), 
					resultado.getData().getADA().getQuote().getUSD().getPrice(), 
					resultado.getData().getADA().getSymbol(),
					resultado.getData().getADA().getLast_updated()));
		}
		
		return aux;
	}

	
}
