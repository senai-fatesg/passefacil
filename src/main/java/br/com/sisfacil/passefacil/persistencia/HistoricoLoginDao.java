package br.com.sisfacil.passefacil.persistencia;

import java.util.List;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.jpa.persistencia.Persistencia;
import br.com.sisfacil.passefacil.entidade.HistoricoLancamento;

public interface HistoricoLoginDao extends Persistencia<HistoricoLancamento>{

	public List<HistoricoLancamento> listarHistoricosPorId(long codigo) throws PersistenciaException;
	
}
