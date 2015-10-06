package br.com.sisfacil.passefacil.entidade.compra;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private String id; //id do servico
	private static String description = "COMPRA DE CRÉDITO"; //descricao do produto/servico
	private double amount; //valor do servico, representa o pre�o unitario do servico
	private static int quantity = 1; //quantidade do produto
	private double weight; //corresponde ao peso
	
	
	/**
	 * Identificam os itens sendo pagos. Voc� pode escolher c�digos que tenham significado para seu sistema e inform�-los nestes par�metros. O PagSeguro n�o realiza qualquer valida��o sobre esses identificadores, mas eles n�o podem se repetir em um mesmo pagamento.
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Livre, com limite de 100 caracteres.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Identificam os itens sendo pagos. Voc� pode escolher c�digos que tenham significado para seu sistema e inform�-los nestes par�metros. O PagSeguro n�o realiza qualquer valida��o sobre esses identificadores, mas eles n�o podem se repetir em um mesmo pagamento.
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Livre, com limite de 100 caracteres.
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Descrevem os itens sendo pagos. A descri��o � o texto que o PagSeguro mostra associado a cada item quando o comprador est� finalizando o pagamento, portanto � importante que ela seja clara e explicativa.
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Livre, com limite de 100 caracteres.
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Descrevem os itens sendo pagos. A descri��o � o texto que o PagSeguro mostra associado a cada item quando o comprador est� finalizando o pagamento, portanto � importante que ela seja clara e explicativa.
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Livre, com limite de 100 caracteres.
	 * @throws Exception 
	 */
	public void setDescription(String description) throws Exception {
		if(description.length() <= 100){
			this.description = description;
		}else {
			throw new Exception("O numero maximo de caracter permitido e 100");
		}
	}
	
	/**
	 * Representam os pre�os unit�rios de cada item sendo pago. Al�m de poder conter v�rios itens, o pagamento tamb�m pode conter v�rias unidades do mesmo item. Este par�metro representa o valor de uma unidade do item, que ser� multiplicado pela quantidade para obter o valor total dentro do pagamento.
		Presen�a: Obrigat�ria.
		Tipo: N�mero.
		Formato: Decimal, com duas casas decimais separadas por ponto (p.e., 1234.56), maior que 0.00 e menor ou igual a 9999999.00.
	 */
	public double getAmount() {
		return amount;
	}
	
	/**
	 * Representam os pre�os unit�rios de cada item sendo pago. Al�m de poder conter v�rios itens, o pagamento tamb�m pode conter v�rias unidades do mesmo item. Este par�metro representa o valor de uma unidade do item, que ser� multiplicado pela quantidade para obter o valor total dentro do pagamento.
		Presen�a: Obrigat�ria.
		Tipo: N�mero.
		Formato: Decimal, com duas casas decimais separadas por ponto (p.e., 1234.56), maior que 0.00 e menor ou igual a 9999999.00.
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	/**
	 * Representam as quantidades de cada item sendo pago. Al�m de poder conter v�rios itens, o pagamento tamb�m pode conter v�rias unidades do mesmo item. Este par�metro representa a quantidade de um item, que ser� multiplicado pelo valor unit�rio para obter o valor total dentro do pagamento.
		Presen�a: Obrigat�ria.
		Tipo: N�mero.
		Formato: Um n�mero inteiro maior ou igual a 1 e menor ou igual a 999.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Correspondem ao peso (em gramas) de cada item sendo pago. O PagSeguro usa o peso do item para realizar o c�lculo do custo de frete nos Correios, exceto se o custo de frete do item j� for especificado diretamente. Veja mais sobre as regras de c�lculo de frete.
		Presen�a: Opcional.
		Tipo: N�mero.
		Formato: Um n�mero inteiro correspondendo ao peso em gramas do item. A soma dos pesos de todos os produtos n�o pode ultrapassar 30000 gramas (30 kg).
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Correspondem ao peso (em gramas) de cada item sendo pago. O PagSeguro usa o peso do item para realizar o c�lculo do custo de frete nos Correios, exceto se o custo de frete do item j� for especificado diretamente. Veja mais sobre as regras de c�lculo de frete.
		Presen�a: Opcional.
		Tipo: N�mero.
		Formato: Um n�mero inteiro correspondendo ao peso em gramas do item. A soma dos pesos de todos os produtos n�o pode ultrapassar 30000 gramas (30 kg).
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
