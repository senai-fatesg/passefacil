package br.com.sisfacil.passefacil.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sisfacil.passefacil.entidade.Aparelho;
import br.com.sisfacil.passefacil.entidade.Conta;
import br.com.sisfacil.passefacil.entidade.Credencial;
import br.com.sisfacil.passefacil.entidade.CredencialAcesso;
import br.com.sisfacil.passefacil.entidade.Pessoa;
import br.com.sisfacil.passefacil.util.ConvertJson;
import br.com.sisfacil.passefacil.util.UtilitarioDateTime;
import br.com.sisfacil.passefacil.vo.ObjetoComunicacaoVO;

@Path("/registrar")
public class ServiceRegistrar {

	@Path("/obterRegistro")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String obterRegistro(){
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("aureliano");
		pessoa.setCpf("67266288718");
		
		
		return ConvertJson.ConvertObjetoEmJson(pessoa);
	}
	
	@Path("/registrarPessoa")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String registrarPessoa(String pessoa){
		try{
			
			ObjetoComunicacaoVO objetoComunicacaoVo = new ObjetoComunicacaoVO();
			objetoComunicacaoVo = ConvertJson.ConvertJsonEmObjeto(pessoa);
			
			
			
			
		}catch(Exception erro){
			
		}
		
		return "Registrado com sucesso!";
	}
	
	public void ConvertaCredencial(ObjetoComunicacaoVO objeto){
		
	}
	
	public void ConvertaCredencialAcesso(){
		
	}
	
	public void ConvertaConta(){
		
	}
}
