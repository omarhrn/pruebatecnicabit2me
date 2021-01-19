package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import java.util.List;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;

public interface EmailService {

	public void enviarEmailSimple(List<Criptomoneda> listaCriptomonedas);
}
