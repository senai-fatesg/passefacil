package br.com.sisfacil.passefacil.negocio;

import br.com.sisfacil.passefacil.entidade.Credencial;
import br.com.sisfacil.passefacil.persistencia.CredencialDao;
import br.com.sisfacil.passefacil.util.ConvertJson;

/**
 * Classe responsavel por autenticar o usuario*/
public class Autenticacao {
	
	private CredencialDao credencialDao;
	//TODO implementar criptografia
	/**
	 * Autentica o usuario por meio da verificação de existencia de dados na base e o 
	 * status do usuario*/
	public boolean Autenticar(String objetoRecebido) throws Exception{
		boolean resultado = false;
		try{
			Credencial credencial = new Credencial();
			credencial = ConvertJson.ConvertJsonEmObjetoCredencial(objetoRecebido);
			Credencial credencialConsulta = new Credencial();
			credencialConsulta = credencialDao.consultar(credencial.getId());
			if(credencialConsulta.getLogin().isEmpty()&& credencial.getSenha().isEmpty()){
				resultado = true;				
			}else{
				resultado = false;
			}
		}catch(Exception erro){
			throw new Exception("Falha na autenticação. Erro ocorreu devido a:" + erro.getMessage());
		}
		return resultado;
	}
}
