package br.com.sisfacil.passefacil.util;

import java.util.List;

public class UtilitarioManipuladorDeLista {

	/**Verificar se o objeto não e nulo ou vazio*/
	public boolean ObjetoEhConsistente(Object objeto){
		if(objeto != null && objeto != "")
			return true;
		return false;
	}
	
	/**Verificar se a lista não e nulo ou vazio*/
	public boolean ListaEhConsistente(List<Object> listaObjeto){
		if(listaObjeto != null && !listaObjeto.isEmpty() && listaObjeto.size() > 0)
			return true;
		return false;
	}
}
