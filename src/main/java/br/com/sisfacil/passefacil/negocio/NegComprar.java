package br.com.sisfacil.passefacil.negocio;

import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.sisfacil.passefacil.entidade.Lancamento;
import br.com.sisfacil.passefacil.persistencia.LancamentoDao;
import br.com.sisfacil.passefacil.util.UtilitarioDateTime;
import br.com.sisfacil.passefacil.vo.ComprarVO;

public class NegComprar {

	private Lancamento lancamento = new Lancamento();
	private LancamentoDao lancamentoDao;
	
	public ComprarVO creditar(double valorCreditar, int id)throws Exception{
		ComprarVO compraVO = new ComprarVO();
		try {
			lancamento.setValor(lancamentoDao.consultar(id).getValor());
			lancamento.setDataLancamento(UtilitarioDateTime.ToHoraAtual());
			compraVO.setValor(lancamento.creditar(valorCreditar));
			lancamentoDao.alterar(lancamento);
			compraVO.setMensagem("Valor creditado com sucesso!");
		} catch (PersistenciaException erro) {
			throw new Exception("Falha ao tentar creditar. \n Erro ocorreu devido a:" + erro.getMessage());
		}
		return compraVO;
	}
	
	public ComprarVO debitar(double valorDebitar, int id) throws Exception{
		ComprarVO compraVO = new ComprarVO();
		try{
			lancamento.setValor(lancamentoDao.consultar(id).getValor());
			lancamento.setDataLancamento(UtilitarioDateTime.ToHoraAtual());
			compraVO.setValor(lancamento.debitar(valorDebitar));
			if(compraVO.getValor() < 0){
				compraVO.setMensagem("Saldo insuficiente.");
				return compraVO; 
			}else{
				lancamentoDao.alterar(lancamento);
				compraVO.setMensagem("Acesso liberado!");
			}
		}catch(Exception erro){
			throw new Exception("Falha ao tentar debitar. \n Erro ocorreu devido a:" + erro.getMessage());
		}
		return compraVO;
	}
	
}
