package br.com.sisfacil.passefacil.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class CredencialAcesso {
	
	@Id
	@GeneratedValue(generator = "credencialacesso_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "credencialacesso_seq", sequenceName = "credencialacesso_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nfcid;
	
	@ManyToOne(optional=false)
	private Aparelho aparelho;
	
	public CredencialAcesso(){
		aparelho = new Aparelho();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNfcid() {
		return nfcid;
	}
	public void setNfcid(String nfcid) {
		this.nfcid = nfcid;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
}
