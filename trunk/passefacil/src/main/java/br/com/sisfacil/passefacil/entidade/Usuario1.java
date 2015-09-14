package br.com.sisfacil.passefacil.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario1 {

	@Id
	@GeneratedValue(generator = "usuario_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String nome;
	private String cpf;
	private String telefone;
	private Credencial credencial;
	private CredencialAcesso credencialAcesso;
	private Conta conta;

	public Usuario1(){
		credencialAcesso = new CredencialAcesso();
		conta = new Conta();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	public CredencialAcesso getCredencialAcesso() {
		return credencialAcesso;
	}

	public void setCredencialAcesso(CredencialAcesso credencialAcesso) {
		this.credencialAcesso = credencialAcesso;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
