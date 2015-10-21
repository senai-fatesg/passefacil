package br.com.sisfacil.passefacil.persistencia;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sisfacil.passefacil.entidade.Pessoa;

public interface PessoaDao extends Persistencia<Pessoa> {

	public Pessoa consultarPorNome(String nome) throws PersistenciaException;
}
