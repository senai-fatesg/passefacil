package br.com.sisfacil.passefacil.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class ServiceRegistrar {

	
	@Path("/registrarPessoa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarPessoa(String pessoa){
	
		
		//TODO Implementar o service de registrar pessoa
		
		return "";
	}
}
