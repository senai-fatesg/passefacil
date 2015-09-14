package br.com.sisfacil.passefacil.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Credencial {

	@Id
	@GeneratedValue(generator = "credencial_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "credencial_seq", sequenceName = "credencial_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String login;
	private String senha;
	private String confirmaSenha;
	private String email;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
