package br.com.sisfacil.passefacil.util;

import br.com.sisfacil.passefacil.entidade.ObjetoComunicacao;

import com.google.gson.Gson;

public class ConvertJson {

	public static ObjetoComunicacao ConvertJsonEmObjeto(String objeto) {
		Gson gson = new Gson();
		return gson.fromJson(objeto, ObjetoComunicacao.class);
	}

	public static String ConvertObjetoEmJson(Object objeto) {
		Gson gson = new Gson();
		return gson.toJson(objeto);
	}
}
