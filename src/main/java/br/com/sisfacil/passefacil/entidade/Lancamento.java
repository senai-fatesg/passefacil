package br.com.sisfacil.passefacil.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lancamento {

	@Id
	@GeneratedValue(generator = "lancamento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "lancamento_seq", sequenceName = "lancamento_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private double valor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataLancamento;

	public void creditar(double valorCreditar){
		//TODO ainda nao implementado
	}
	
	public void debitar(double valorDebitar){
		//TODO ainda nao implementado
	}

	
	/*
	 * Getters and Setters
	 */
	public Integer getId() {
		return id;
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

	
}
