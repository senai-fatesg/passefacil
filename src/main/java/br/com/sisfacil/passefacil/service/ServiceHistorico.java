package br.com.sisfacil.passefacil.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.sisfacil.passefacil.entidade.HistoricoLancamento;
import br.com.sisfacil.passefacil.negocio.NegAutenticar;
import br.com.sisfacil.passefacil.persistencia.HistoricoLoginDao;
import br.com.sisfacil.passefacil.util.ConvertJson;
import br.com.sisfacil.passefacil.vo.ObjetoComunicacaoVO;

import com.google.gson.Gson;

/**Service Historico tem como finalidade atender os requisitos da tela de 
 * consulta Histórico do sistema mobile*/

@Path("/historico")
public class ServiceHistorico {
	
	@Autowired
	private HistoricoLoginDao historicoDao;
	
	private List<HistoricoLancamento> Historicos = new ArrayList<HistoricoLancamento>();
	
	//TODO implementar service para a obtenção de historico de acordo com a requisição do usuario
	
	/**
	 * Obtem o historico de login.
	 * Parametro: ObjetoComunicacao com o tipo do objetoRetorno como HistoricoLogin
	 * Retornar um objeto Json com os dados anteriores informados e o 
	 * HistoricoLogin solicitado.*/
	@Path("/postObtenhaHistoricoPorId")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postObtenhaHistoricoPorId(String objetoHistorico){
		
		ObjetoComunicacaoVO objetoErroComunicacao = new ObjetoComunicacaoVO();//Objeto utilizado para a converção do Json recebido
		ObjetoComunicacaoVO objetoComunicacao = new ObjetoComunicacaoVO();//objeto utilizado quando ocorreu algum erro durante a execução do programa
		Gson gson = new Gson();
		
		try{
			objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(objetoHistorico);
			objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), HistoricoLancamento.class));
			
			if(!objetoComunicacao.getObjetoAutenticacao().isEmpty()){
				//TODO implementar a autenticação do usuario
				NegAutenticar autenticacao = new NegAutenticar();
				autenticacao.Autenticar(objetoComunicacao.getObjetoAutenticacao());
				
				//Obtendo o historico por meio do id informado
				HistoricoLancamento historicoLogin = new HistoricoLancamento();
				historicoLogin = (HistoricoLancamento)objetoComunicacao.getObjetoRetorno();
				historicoDao.consultar(historicoLogin.getId());
				
			}else{
				objetoErroComunicacao.setMensagem("Por favor, Informe suas credenciais!");
				objetoErroComunicacao.setStatus(false);
				objetoErroComunicacao.setObjetoRetorno(objetoComunicacao.getObjetoRetorno());
			}
		}catch(Exception erro){
			objetoErroComunicacao.setMensagem("Erro durante a obtenção do historico, \n"
					+ "Por favor, verifique se o Json esta correto.");
			objetoErroComunicacao.setStatus(false);
			objetoErroComunicacao.setObjetoRetorno(objetoComunicacao.getObjetoRetorno());
			return ConvertJson.ConvertObjetoEmJson(objetoErroComunicacao);
		}
		return ConvertJson.ConvertObjetoEmJson(objetoComunicacao);
	}
	
	
	@Path("/postObtenhaTodosHistoricosPorId")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String postObtenhaTodosHistoricosPorId(String objetoHistorico){
		
		ObjetoComunicacaoVO objetoErroComunicacao = new ObjetoComunicacaoVO();//Objeto utilizado para a converção do Json recebido
		ObjetoComunicacaoVO objetoComunicacao = new ObjetoComunicacaoVO();//objeto utilizado quando ocorreu algum erro durante a execução do programa
		Gson gson = new Gson();
		
		try{
			objetoComunicacao = ConvertJson.ConvertJsonEmObjeto(objetoHistorico);
			objetoComunicacao.setObjetoRetorno(gson.fromJson(objetoComunicacao.getObjetoRetorno().toString(), HistoricoLancamento.class));
			
			if(!objetoComunicacao.getObjetoAutenticacao().isEmpty()){
				//TODO implementar a autenticação do usuario
				
				//Obtendo o historico por meio do id informado
				HistoricoLancamento historicoLogin = new HistoricoLancamento();
				historicoLogin = (HistoricoLancamento)objetoComunicacao.getObjetoRetorno();
				objetoComunicacao.setObjetoRetorno(historicoDao.listarHistoricosPorId(historicoLogin.getId()));
				
			}else{
				objetoErroComunicacao.setMensagem("Por favor, Informe suas credenciais!");
				objetoErroComunicacao.setStatus(false);
				objetoErroComunicacao.setObjetoRetorno(objetoComunicacao.getObjetoRetorno());
			}
		}catch(Exception erro){
			objetoErroComunicacao.setMensagem("Erro durante a obtenção do historico, \n"
					+ "Por favor, verifique se o Json esta correto.");
			objetoErroComunicacao.setStatus(false);
			objetoErroComunicacao.setObjetoRetorno(objetoComunicacao.getObjetoRetorno());
			return ConvertJson.ConvertObjetoEmJson(objetoErroComunicacao);
		}
		return ConvertJson.ConvertObjetoEmJson(objetoComunicacao);
	}
}
