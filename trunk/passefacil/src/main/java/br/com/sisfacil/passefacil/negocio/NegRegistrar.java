package br.com.sisfacil.passefacil.negocio;

import br.com.sisfacil.passefacil.entidade.Aparelho;
import br.com.sisfacil.passefacil.entidade.Pessoa;
import br.com.sisfacil.passefacil.persistencia.AparelhoDao;
import br.com.sisfacil.passefacil.persistencia.PessoaDao;

public class NegRegistrar {

	private Pessoa pessoa = new Pessoa();
	private Aparelho aparelho = new Aparelho();
	private AparelhoDao aparelhoDao;
	private PessoaDao pessoaDao;
	
	public boolean registrar(Pessoa pessoa, Aparelho aparelho){
		
		return true;
		
	}
}
