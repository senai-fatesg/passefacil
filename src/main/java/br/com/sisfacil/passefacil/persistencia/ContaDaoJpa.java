package br.com.sisfacil.passefacil.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.Conta;

@Repository("contaDao")
public class ContaDaoJpa extends PersistenciaJpa<Conta> implements ContaDao {

	private static final long serialVersionUID = 1L;

}