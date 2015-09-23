package br.com.sisfacil.passefacil.vo;

public class ObjetoComunicacaoVO {

	private String mensagem;
	private Boolean status;
	private Object objetoRetorno;
	private String objetoAutenticacao;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Object getObjetoRetorno() {
		return objetoRetorno;
	}
	public void setObjetoRetorno(Object objetoRetorno) {
		this.objetoRetorno = objetoRetorno;
	}
	public String getObjetoAutenticacao() {
		return objetoAutenticacao;
	}
	public void setObjetoAutenticacao(String objetoAutenticacao) {
		this.objetoAutenticacao = objetoAutenticacao;
	}
}
