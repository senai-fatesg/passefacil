package br.com.sisfacil.passefacil.entidade;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Lancamento {

	@Id
	@GeneratedValue(generator = "lancamento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "lancamento_seq", sequenceName = "lancamento_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private double valor;
	private Date dataLancamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public void creditar(double valorCreditar){
		
	}
	
	public void debitar(double valorDebitar){
		
	}
	
}
