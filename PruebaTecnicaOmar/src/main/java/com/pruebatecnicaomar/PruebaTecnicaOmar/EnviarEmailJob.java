package com.pruebatecnicaomar.PruebaTecnicaOmar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.pruebatecnicaomar.PruebaTecnicaOmar.api.CriptomonedasApiImpl;

public class EnviarEmailJob implements Job {

	@Autowired
	private CriptomonedasApiImpl criptomonedasApi;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Tarea enviar email");
		criptomonedasApi.enviarEmail();
		
	}

}
