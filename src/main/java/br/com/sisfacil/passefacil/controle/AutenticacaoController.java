package br.com.sisfacil.passefacil.controle;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.bytecode.ByteArray;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sysfacil.passefacil.entidade.*;
import br.com.sysfacil.passefacil.entidade.Aparelho;
import br.com.sysfacil.passefacil.entidade.Usuario1;
import br.com.sysfacil.passefacil.entidade.ObjetoComunicacao;
import br.com.sysfacil.passefacil.util.ConvertJson;
import br.com.sysfacil.passefacil.util.UtilitarioCriptografia;

import com.google.gson.Gson;

@Path("/autenticacao")
public class AutenticacaoController {

	private Aparelho aparelho;
	private String mensagem;
	
	
	
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
		
		ObjetoComunicacao objetoComunicacao = new ObjetoComunicacao();
		Gson gson = new Gson();
		objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(credencial);
		objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), Usuario1.class));
		
		if(!objetoComunicacao.getObjetoAutenticacao().isEmpty()){
			//verificar se existe dados
			//verificar se aparelho e pr�-pago ou p�s-pago
			//
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
		
		ObjetoComunicacao objetoComunicacao = new ObjetoComunicacao();
		Gson gson = new Gson();
		objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(objetoRecebido);
		objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), Usuario1.class));
		
		if(!objetoComunicacao.getObjetoAutenticacao().isEmpty()){
			//
			
			
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
		
		ObjetoComunicacao objetoComunicacao = new ObjetoComunicacao();
		Gson gson = new Gson();
		objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(objetoRecebido);
		objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), Usuario1.class));
		
		Usuario1 cliente = new Usuario1();
		cliente = (Usuario1)objetoComunicacao.getObjetoRetorno();
		if(!cliente.getCredencialAcesso().getNfcid().isEmpty()){
			//verificar se ja existe cliente cadastrado na base de dados com o nfcid e imei

			
			//salvar cliente na base de dados de acordo com o tipo do cliente
			
			//devolve status para o smatphone por meio do json(ObjetoComunicacao)
			objetoComunicacao = new ObjetoComunicacao();
			objetoComunicacao.setStatus(true);
			mensagem = "As informa��es foram salvas com sucesso!";
			objetoComunicacao.setMensagem(mensagem);
			objetoComunicacao.setObjetoRetorno(true);
			
		}else{
			//Objeto que ser� retornado caso o NFC ou o IMEI do aparelho n�o forem obtidos
			objetoComunicacao = new ObjetoComunicacao();
			objetoComunicacao.setStatus(false);
			mensagem = "N�o foi poss�vel receber o NFC ou o Imei do seu aparelho";
			objetoComunicacao.setMensagem(mensagem);
			objetoComunicacao.setObjetoRetorno(gson.toJson(cliente));
		}
		
		return ConvertJson.ConvertObjetoEmJson(objetoComunicacao);
	}
	
	
}
