package br.com.sisfacil.passefacil.entidade;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Conta {

	@Id
	@GeneratedValue(generator = "conta_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "conta_seq", sequenceName = "conta_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private double saldo;
	private EnumFormaFaturamento formaFaturamento;
	private List<Lancamento> listaLancamento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public EnumFormaFaturamento getFormaFaturamento() {
		return formaFaturamento;
	}
	public void setFormaFaturamento(EnumFormaFaturamento formaFaturamento) {
		this.formaFaturamento = formaFaturamento;
	}
	public List<Lancamento> getListaLancamento() {
		return listaLancamento;
	}
	public void setListaLancamento(List<Lancamento> listaLancamento) {
		this.listaLancamento = listaLancamento;
	}
}
