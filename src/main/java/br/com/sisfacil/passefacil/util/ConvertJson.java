package br.com.sisfacil.passefacil.util;

import br.com.sisfacil.passefacil.vo.ObjetoComunicacaoVO;

import com.google.gson.Gson;


public class ConvertJson {

	public static ObjetoComunicacaoVO ConvertJsonEmObjeto(String objeto) {
		Gson gson = new Gson();
		return gson.fromJson(objeto, ObjetoComunicacaoVO.class);
	}

	public static String ConvertObjetoEmJson(Object objeto) {
		Gson gson = new Gson();
		return gson.toJson(objeto);
	}
}
