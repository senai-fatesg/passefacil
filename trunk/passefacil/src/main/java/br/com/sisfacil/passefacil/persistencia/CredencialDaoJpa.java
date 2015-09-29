package br.com.sisfacil.passefacil.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.Credencial;

@Repository("credencialDao")
public class CredencialDaoJpa extends PersistenciaJpa<Credencial> implements
		CredencialDao {

	private static final long serialVersionUID = 1L;

}