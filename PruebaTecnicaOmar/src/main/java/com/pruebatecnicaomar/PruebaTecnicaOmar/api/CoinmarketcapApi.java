package com.pruebatecnicaomar.PruebaTecnicaOmar.api;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Root;


public class CoinmarketcapApi {

	private static final String HEADER1 = "x-cmc_pro_api_key"; 
	private static final String APIKEY	= "028eab42-a9cb-4d9a-8375-d388c6d9e8d1";
	private final static String URL 	= "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
	
	public static Root coinmarketcapInfoCoins(String symbolsCoins) {
		final String urlConParametros = new String(URL).concat("?symbol=").concat(symbolsCoins);

	    RestTemplate restTemplate = new RestTemplate();
	    
	    final HttpHeaders headers = new HttpHeaders();
	    
        headers.set(HEADER1, APIKEY);
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        
        //Execute the method writing your HttpEntity to the request
        ResponseEntity<Map> response = restTemplate.exchange(urlConParametros, HttpMethod.GET, entity, Map.class);        
       
        Root root = null;
        ObjectMapper om = new ObjectMapper();
        try {
        	String json = om.writeValueAsString(response.getBody());
			root = om.readValue(json, Root.class);
						
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(response.getBody());
        
        return root;
	}
	
	
}
