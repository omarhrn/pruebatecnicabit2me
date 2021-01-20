package com.pruebatecnicaomar.PruebaTecnicaOmar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pruebatecnicaomar.PruebaTecnicaOmar.api.CriptomonedasApiImpl;

@Controller
public class IndexController {
	
	@Autowired
	private CriptomonedasApiImpl criptomonedasApi;
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute("criptomonedaBTC", criptomonedasApi.getPrecioCriptomonedaByNombre("bitcoin"));
		model.addAttribute("criptomonedaADA", criptomonedasApi.getPrecioCriptomonedaByNombre("cardano"));
		model.addAttribute("criptomonedaLRC", criptomonedasApi.getPrecioCriptomonedaByNombre("loopring"));
		return "index";
	}
}
