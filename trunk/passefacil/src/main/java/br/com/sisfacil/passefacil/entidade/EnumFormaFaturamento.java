package br.com.sisfacil.passefacil.entidade;

import br.com.ambientinformatica.util.IEnum;

public enum EnumFormaFaturamento implements IEnum{

	PREPAGO("pre-pago"),
	POSPAGO("pos-pago");

	private String descricao;

	EnumFormaFaturamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
