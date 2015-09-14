package br.com.sisfacil.passefacil.entidade;

public enum EnumTipo {

	CREDITO("credito"),
	DEBITO("debito");

	private String descricao;

	EnumTipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
