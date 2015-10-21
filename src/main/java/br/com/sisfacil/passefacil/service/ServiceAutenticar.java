package br.com.sisfacil.passefacil.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sisfacil.passefacil.dto.DTOCompra;
import br.com.sisfacil.passefacil.entidade.Aparelho;
import br.com.sisfacil.passefacil.entidade.Pessoa;
import br.com.sisfacil.passefacil.util.ConvertJson;
import br.com.sisfacil.passefacil.vo.ObjetoComunicacaoVO;

import com.google.gson.Gson;

@Path("/autenticar")
public class ServiceAutenticar {

	private Aparelho aparelho;
	private String mensagem;
	
	//TODO implementar service para autenticar o usuario no momento do login
	
	static private Map<Integer, DTOCompra> dtoCompraMap;
	
	static {
		dtoCompraMap = new HashMap<Integer, DTOCompra>();

		DTOCompra dtoCompra = new DTOCompra();
		dtoCompra.setBairro("setor universitario");
		

		dtoCompraMap.put(dtoCompra.getId(), dtoCompra);
	}
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public List<DTOCompra> credencial(){
		return new ArrayList<DTOCompra>(dtoCompraMap.values());
	}
	
	@Path("/postAutenticar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postAutenticar(String credencial){
		
		ObjetoComunicacaoVO objetoComunicacao = new ObjetoComunicacaoVO();
		Gson gson = new Gson();
		objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(credencial);
		objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), Pessoa.class));
		
		if(!objetoComunicacao.getObjetoAutenticacao().isEmpty()){
			//verificar se existe dados
			//verificar se aparelho e pre-pago ou pos-pago
			
			return gson.toJson(objetoComunicacao);
			
		}else{
			
			return "nao deu certo";
		}
	}
	
	@Path("/postCompraCredito")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postCompraCredito(String objetoRecebido){
		
		ObjetoComunicacaoVO objetoComunicacao = new ObjetoComunicacaoVO();
		Gson gson = new Gson();
		objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(objetoRecebido);
		objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), Pessoa.class));
		
		if(!objetoComunicacao.getObjetoAutenticacao().isEmpty()){
			
			return gson.toJson(objetoComunicacao);
			
		}else{
			
			return "nao deu certo";
		}
	}
	
	@Path("/postRegistrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postRegistrar(String objetoRecebido){
		
		ObjetoComunicacaoVO objetoComunicacao = new ObjetoComunicacaoVO();
		Gson gson = new Gson();
		objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(objetoRecebido);
		objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), Pessoa.class));
		
		Pessoa cliente = new Pessoa();
		cliente = (Pessoa)objetoComunicacao.getObjetoRetorno();
		if(!cliente.getCredencialAcesso().getNfcid().isEmpty()){
			//verificar se ja existe cliente cadastrado na base de dados com o nfcid e imei

			
			//salvar cliente na base de dados de acordo com o tipo do cliente
			
			//devolve status para o smatphone por meio do json(ObjetoComunicacao)
			objetoComunicacao = new ObjetoComunicacaoVO();
			objetoComunicacao.setStatus(true);
			mensagem = "As informações foram salvas com sucesso!";
			objetoComunicacao.setMensagem(mensagem);
			objetoComunicacao.setObjetoRetorno(true);
			
		}else{
			//Objeto que será retornado caso o NFC ou o IMEI do aparelho não forem obtidos
			objetoComunicacao = new ObjetoComunicacaoVO();
			objetoComunicacao.setStatus(false);
			mensagem = "Não e possiveil receber o IMEI do aparelho";
			objetoComunicacao.setMensagem(mensagem);
			objetoComunicacao.setObjetoRetorno(gson.toJson(cliente));
		}
		
		return ConvertJson.ConvertObjetoEmJson(objetoComunicacao);
	}
	
	
	
}
