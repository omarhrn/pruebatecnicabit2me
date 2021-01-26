package com.pruebatecnicaomar.PruebaTecnicaOmar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pruebatecnicaomar.PruebaTecnicaOmar.dto.Criptomoneda;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private MessageSource mensajes;

	@Override
	public void enviarEmailSimple(List<Criptomoneda> listaCriptomonedas) {
	
		String stringNombrePrecio = "";
		for(Criptomoneda c : listaCriptomonedas) {
			stringNombrePrecio = stringNombrePrecio.concat(c.getNombre()).concat(" : ").concat(Double.toString(c.getPrecio())).concat(" \n ");
		}
		
		SimpleMailMessage mensaje = new SimpleMailMessage();
		mensaje.setFrom("omarr1354@gmail.com");
		mensaje.setTo(new String[]{"omarr1354@gmail.com","dev-test@team.bit2me.com"});
		mensaje.setSubject( "PruebaTecnica-OmarRendon / TechnicalTest-OmarRendon");
		mensaje.setText("\nHola \nEl precio ($) actual de las criptomonedas es: \n".concat(stringNombrePrecio)
				.concat("\nHello \nThe current price ($) of cryptocurrencies is: \n".concat(stringNombrePrecio)));
		emailSender.send(mensaje);
		
	}

}
