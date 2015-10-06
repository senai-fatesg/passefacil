package br.com.sisfacil.passefacil.persistencia;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.sisfacil.passefacil.entidade.HistoricoLancamento;

@Repository("historicoLoginDao")
public class HistoricoLoginDaoJpa extends PersistenciaJpa<HistoricoLancamento> implements HistoricoLoginDao {

	private static final long serialVersionUID = 1L;

	/**
	 * Obtem uma lista de HitoricoLogin por meio do id informado, retornando no maximo 200 registros*/
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor=PersistenciaException.class)
	@Override
	public List<HistoricoLancamento> listarHistoricosPorId(long codigo) throws PersistenciaException{
		try {
			Query query = em.createQuery("select e from historicologin where id = " + codigo +  " e");
			query.setMaxResults(200);
			return query.getResultList();
		} catch (Exception e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
	}
	

	
}
