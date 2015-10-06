package br.com.sisfacil.passefacil.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.sisfacil.passefacil.entidade.EnumStatus;
import br.com.sisfacil.passefacil.entidade.Lancamento;

/**DTO de consulta historico. */
public class DTOConsultaHistorico {
	
	private String imei;
	private String nfcId;
	private EnumStatus status;
	private String Login;
	private String senha;
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getNfcId() {
		return nfcId;
	}
	public void setNfcId(String nfcId) {
		this.nfcId = nfcId;
	}
	public EnumStatus getStatus() {
		return status;
	}
	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	
	
}
