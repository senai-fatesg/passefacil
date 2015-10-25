package br.com.sisfacil.passefacil.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sisfacil.passefacil.vo.ObjetoComunicacaoVO;

public class ServiceRegistrar {

	
	@Path("/registrarPessoa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarPessoa(String pessoa){
		try{
			
			ObjetoComunicacaoVO objetoComunicacaoVo = new ObjetoComunicacaoVO();
			
			
			
			
		}catch(Exception erro){
			
		}
		
		return "Registrado com sucesso!";
	}
	
	public void ConvertaCredencial(){
		
	}
	
	public void ConvertaCredencialAcesso(){
		
	}
	
	public void ConvertaConta(){
		
	}
}
