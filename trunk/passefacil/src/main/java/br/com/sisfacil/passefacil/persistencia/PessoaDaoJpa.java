package br.com.sisfacil.passefacil.persistencia;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.Pessoa;

@Repository("pessoaDao")
public class PessoaDaoJpa extends PersistenciaJpa<Pessoa> implements PessoaDao{

	private static final long serialVersionUID = 1L;

	
	@Transactional(rollbackFor=PersistenciaException.class)
	@Override
	public Pessoa consultarPorNome(String nome)throws PersistenciaException {
		try {
			return em.find(Pessoa.class, nome);
		} catch (EntityNotFoundException e) {
			return null;
		} catch (RuntimeException e) {
			throw new PersistenciaException(String.format("Problemas ao consultar o registro %s com id %s", nome), e);
		}
	}
	
	
}
