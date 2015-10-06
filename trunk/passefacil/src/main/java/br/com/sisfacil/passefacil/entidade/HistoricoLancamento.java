package br.com.sisfacil.passefacil.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class HistoricoLancamento {

	@Id
	@GeneratedValue(generator = "historico_lancamento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "historico_lancamento_seq", sequenceName = "historico_lancamento_seq", allocationSize = 1, initialValue = 1)
	private Long id;

	@ManyToOne
	private Pessoa pessoa;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	public Pessoa getPessoa() {
		return pessoa;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "historico_lancamento")
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

}
