package br.com.sisfacil.passefacil.entidade;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DTOCompra {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Dados obrigatorios para a integra��o com o pagseguro
	private String email;

	private String token = "E652D98312A44E318868856C93861254";

	private String modeda = "BRL";
	
	private String codigoReferencia; //codigo fica associado ao pagamento
	
	private String descricao;
		
	private BigDecimal valorUnitarioItem;

	private Integer quantidadeItem;
	
	/**Dados opcionais para a integra��o com o pagseguro*/
	
	//dados pessoais do comprador
	private String nomeComprado;
	private String emailComprador;
	private Integer cpfComprador;
	private Date dataNascimentoComprador;
	
	private String pais = "BRA";
	private String estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String nomeRua;
	private String numeroCasa;
	private String complemento;
	private String idServico;
	
	/**Dados de utiliza��o propria do sistema*/
	private String urlRedirecionamento;
	private String urlNotificacao;
	
	/**dados de seguran�a*/
	private Integer numeroMaximoParacodigoPagamento;
	private Integer prazoValidadeCodigoPagamento;
	private String urlRedirecionamentoCompradorParaFluxoDePagamento;
	

	/**Especifica o e-mail associado � conta PagSeguro que est� realizando a chamada � API.
	 	Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: um e-mail v�lido (p.e., usuario@site.com.br), com no m�ximo 60 caracteres.
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**Informa o token correspondente � conta PagSeguro que est� realizando a chamada a API.
	 	Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: uma sequ�ncia de 32 caracteres.
	 */
	protected String getToken() {
		return token;
	}

	/**
	public void setToken(String token) {
		this.token = token;
	}
	*/

	/**
    Indica a moeda na qual o pagamento ser� feito. No momento, a �nica op��o dispon�vel � BRL (Real).
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Case sensitive. Somente o valor BRL � aceito.
	 */
	public String getModeda() {
		return modeda;
	}

	/**
	 	Descrevem os itens sendo pagos. A descri��o � o texto que o PagSeguro mostra associado a cada item quando o comprador est� finalizando o pagamento, portanto � importante que ela seja clara e explicativa.
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Livre, com limite de 100 caracteres.
	 */
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 	Representam os pre�os unit�rios de cada item sendo pago. Al�m de poder conter v�rios itens, o pagamento tamb�m pode conter v�rias unidades do mesmo item. Este par�metro representa o valor de uma unidade do item, que ser� multiplicado pela quantidade para obter o valor total dentro do pagamento.
		Presen�a: Obrigat�ria.
		Tipo: N�mero.
		Formato: Decimal, com duas casas decimais separadas por ponto (p.e., 1234.56), maior que 0.00 e menor ou igual a 9999999.00. 
	 */
	public BigDecimal getValorUnitarioItem() {
		return valorUnitarioItem;
	}

	public void setValorUnitarioItem(BigDecimal valorUnitarioItem) {
		this.valorUnitarioItem = valorUnitarioItem;
	}

	/**
	 	Representam as quantidades de cada item sendo pago. Al�m de poder conter v�rios itens, o pagamento tamb�m pode conter v�rias unidades do mesmo item. Este par�metro representa a quantidade de um item, que ser� multiplicado pelo valor unit�rio para obter o valor total dentro do pagamento.
		Presen�a: Obrigat�ria.
		Tipo: N�mero.
		Formato: Um n�mero inteiro maior ou igual a 1 e menor ou igual a 999.
	 */
	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public String getNomeComprado() {
		return nomeComprado;
	}

	public void setNomeComprado(String nomeComprado) {
		this.nomeComprado = nomeComprado;
	}

	public String getEmailComprador() {
		return emailComprador;
	}

	public void setEmailComprador(String emailComprador) {
		this.emailComprador = emailComprador;
	}

	public Integer getCpfComprador() {
		return cpfComprador;
	}

	public void setCpfComprador(Integer cpfComprador) {
		this.cpfComprador = cpfComprador;
	}

	public Date getDataNascimentoComprador() {
		return dataNascimentoComprador;
	}

	public void setDataNascimentoComprador(Date dataNascimentoComprador) {
		this.dataNascimentoComprador = dataNascimentoComprador;
	}

	/**
	 	Informa o pa�s do endere�o de envio do produto. Este campo � opcional e voc� pode envi�-lo caso j� tenha capturado os dados do comprador em seu sistema e queira evitar que ele preencha esses dados novamente no PagSeguro.
		Presen�a: Opcional.
		Tipo: Texto.
		Formato: No momento, apenas o valor BRA � permitido.
	 */
	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	/**
	 	Informa o complemento (bloco, apartamento, etc.) do endere�o de envio do produto. Este campo � opcional e voc� pode envi�-lo caso j� tenha capturado os dados do comprador em seu sistema e queira evitar que ele preencha esses dados novamente no PagSeguro.
		Presen�a: Opcional.
		Tipo: Texto.
		Formato: Livre, com limite de 40 caracteres.
	 */
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 	URL de redirecionamento ap�s o pagamento.
		Determina a URL para a qual o comprador ser� redirecionado ap�s o final do fluxo de pagamento. Este par�metro permite que seja informado um endere�o de espec�fico para cada pagamento realizado. Veja mais em Redirecionando o comprador para um endere�o din�mico.
		Presen�a: Opcional.
		Tipo: Texto.
		Formato: Uma URL v�lida, com limite de 255 caracteres.
	 */
	public String getUrlRedirecionamento() {
		return urlRedirecionamento;
	}

	public void setUrlRedirecionamento(String urlRedirecionamento) {
		this.urlRedirecionamento = urlRedirecionamento;
	}

	/**
		Determina a URL para a qual o PagSeguro enviar� os c�digos de notifica��o relacionados ao pagamento. Toda vez que houver uma mudan�a no status da transa��o e que demandar sua aten��o, uma nova notifica��o ser� enviada para este endere�o.
		Presen�a: Opcional.
		Tipo: Texto.
		Formato: Uma URL v�lida, com limite de 255 caracteres.
	 */
	public String getUrlNotificacao() {
		return urlNotificacao;
	}

	public void setUrlNotificacao(String urlNotificacao) {
		this.urlNotificacao = urlNotificacao;
	}

	/**
	 	Determina o n�mero m�ximo de vezes que o c�digo de pagamento criado pela chamada � API de Pagamentos poder� ser usado. Este par�metro pode ser usado como um controle de seguran�a.
		Presen�a: Opcional.
		Tipo: N�mero.
		Formato: Um n�mero inteiro maior que 0 e menor ou igual a 999.
	 */
	public Integer getNumeroMaximoParacodigoPagamento() {
		return numeroMaximoParacodigoPagamento;
	}

	public void setNumeroMaximoParacodigoPagamento(
			Integer numeroMaximoParacodigoPagamento) {
		this.numeroMaximoParacodigoPagamento = numeroMaximoParacodigoPagamento;
	}

	/**
		Determina o prazo (em segundos) durante o qual o c�digo de pagamento criado pela chamada � API de Pagamentos poder� ser usado. Este par�metro pode ser usado como um controle de seguran�a.
		Presen�a: Opcional.
		Tipo: N�mero.
		Formato: Um n�mero inteiro maior ou igual a 30 e menor ou igual a 999999999.
	 */
	public Integer getPrazoValidadeCodigoPagamento() {
		return prazoValidadeCodigoPagamento;
	}

	public void setPrazoValidadeCodigoPagamento(Integer prazoValidadeCodigoPagamento) {
		this.prazoValidadeCodigoPagamento = prazoValidadeCodigoPagamento;
	}

	/**
	 * C�digo de pagamento retornado pela chamada � API de pagamento do PagSeguro.
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Uma sequ�ncia de 32 caracteres.
	 */
	public String getUrlRedirecionamentoCompradorParaFluxoDePagamento() {
		return urlRedirecionamentoCompradorParaFluxoDePagamento;
	}

	public void setUrlRedirecionamentoCompradorParaFluxoDePagamento(
			String urlRedirecionamentoCompradorParaFluxoDePagamento) {
		this.urlRedirecionamentoCompradorParaFluxoDePagamento = urlRedirecionamentoCompradorParaFluxoDePagamento;
	}

	/**
 	Identificam os itens sendo pagos. Voc� pode escolher c�digos que tenham significado para seu sistema e inform�-los nestes par�metros. O PagSeguro n�o realiza qualquer valida��o sobre esses identificadores, mas eles n�o podem se repetir em um mesmo pagamento.
	Presen�a: Obrigat�ria.
	Tipo: Texto.
	Formato: Livre, com limite de 100 caracteres.
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
 	Identificam os itens sendo pagos. Voc� pode escolher c�digos que tenham significado para seu sistema e inform�-los nestes par�metros. O PagSeguro n�o realiza qualquer valida��o sobre esses identificadores, mas eles n�o podem se repetir em um mesmo pagamento.
	Presen�a: Obrigat�ria.
	Tipo: Texto.
	Formato: Livre, com limite de 100 caracteres.
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public String getIdServico() {
		return idServico;
	}

	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}

}
