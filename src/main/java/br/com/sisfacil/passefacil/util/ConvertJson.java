package br.com.sisfacil.passefacil.util;

import br.com.sisfacil.passefacil.entidade.Credencial;
import br.com.sisfacil.passefacil.vo.ObjetoComunicacaoVO;



public class ConvertJson {

	static Gson gson;
	public static ObjetoComunicacaoVO ConvertJsonEmObjeto(String objeto) {
		gson = new Gson();
		return gson.fromJson(objeto, ObjetoComunicacaoVO.class);
	}

	public static String ConvertObjetoEmJson(Object objeto) {
		Gson gson = new Gson();
		return gson.toJson(objeto);
	}
	
	/**Convert json autenticacao em objeto credencial (objetoAutenticacao)*/
	public static Credencial ConvertJsonEmObjetoCredencial(String objeto){
		gson = new Gson();
		return gson.fromJson(objeto, Credencial.class);
	}
}
