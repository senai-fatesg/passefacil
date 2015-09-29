package br.com.sisfacil.passefacil.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sisfacil.passefacil.entidade.HistoricoLogin;

public interface HistoricoLoginDao extends Persistencia<HistoricoLogin>{

	public List<HistoricoLogin> listarHistoricosPorId(long codigo) throws PersistenciaException;
	
}
