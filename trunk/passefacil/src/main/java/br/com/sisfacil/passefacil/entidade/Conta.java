package br.com.sisfacil.passefacil.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Conta {

	@Id
	@GeneratedValue(generator = "conta_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "conta_seq", sequenceName = "conta_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private double saldo;
	
	@Enumerated(EnumType.STRING)
	private EnumFormaFaturamento formaFaturamento;
	
   @OneToMany(cascade=CascadeType.ALL)
   @JoinColumn(name="conta_id")
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

	public void addLancamento(Lancamento lancamento){
		lancamentos.add(lancamento);
	}

	public void addAllLancamento(List<Lancamento> lancamentos){
		lancamentos.addAll(lancamentos);
	}
	
	public Integer getId() {
		return id;
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

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	
	
}
