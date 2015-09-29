package br.com.sisfacil.passefacil.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.CredencialAcesso;

@Repository("credencialAcessoDao")
public class CredencialAcessoDaoJpa extends PersistenciaJpa<CredencialAcesso>
		implements CredencialAcessoDao {

	private static final long serialVersionUID = 1L;

}
