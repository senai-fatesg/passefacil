package br.com.sisfacil.passefacil.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.Aparelho;

@Repository("aparelhoDao")
public class AparelhoDaoJpa extends PersistenciaJpa<Aparelho> implements AparelhoDao{

	   private static final long serialVersionUID = 1L;

	}