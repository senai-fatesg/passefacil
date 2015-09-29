package br.com.sisfacil.passefacil.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.Lancamento;

@Repository("lancamentoDao")
public class LancamentoDaoJpa extends PersistenciaJpa<Lancamento> implements LancamentoDao{

	private static final long serialVersionUID = 1L;
	
	
	
}
