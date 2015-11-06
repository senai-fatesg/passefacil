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
		pessoa.setTelefone("99222085");
		pessoa.setDataNascimento(UtilitarioDateTime.ToHoraAtual());
		Conta conta = new Conta();
		conta.setSaldo(9.0);
		pessoa.setConta(conta);
		Credencial credencial = new Credencial();
		credencial.setLogin("aurelianos18@gmail.com");
		credencial.setSenha("132");
		pessoa.setCredencial(credencial);
		CredencialAcesso credencialAcesso = new CredencialAcesso();
		credencialAcesso.setNfcid("1231231231");
		Aparelho aparelho = new Aparelho();
		aparelho.setImei("12313245645");
		credencialAcesso.setAparelho(aparelho);
		pessoa.setCredencialAcesso(credencialAcesso);
		
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
