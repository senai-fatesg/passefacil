package br.com.sisfacil.passefacil.entidade;

public enum EnumStatus {

	BLOQUEADO("bloqueado"),
	DESBLOQUEADO("desbloqueado"),
	BLOQPARCILMENTE("bloqueadoparcialmente");

	private String descricao;

	EnumStatus(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
