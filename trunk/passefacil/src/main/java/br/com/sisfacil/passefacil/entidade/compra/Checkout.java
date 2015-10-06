package br.com.sisfacil.passefacil.entidade.compra;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.sisfacil.passefacil.dto.*;

@XmlRootElement
public class Checkout {

	private int id; //numero do pedido não vai para o pagseguro
	
	private String currency = "BRL"; //moeda utilizada
	private Item item; //item vendido
	private List<Item> itens; //itens vendidos
	private String reference; //Codigo de referencia.
	private Sender sender; //Dados do comprador.
	
	public void Currency(){
		sender = new Sender();
		itens = new ArrayList<Item>();
		item = new Item();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void addItem(Item item){
		this.itens.add(item);
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	/**
	 * Indica a moeda na qual o pagamento ser� feito. No momento, a �nica op��o dispon�vel � BRL (Real).
		Presen�a: Obrigat�ria.
		Tipo: Texto.
		Formato: Case sensitive. Somente o valor BRL � aceito.
	 */
	public String getCurrency() {
		return currency;
	}

	/**Lista de itens contidos no pagamento.*/
	public List<Item> getItems() {
		return itens;
	}
	
	/**Lista de itens contidos no pagamento.*/
	public void setItems(List<Item> items) {
		this.itens = items;
	}
	
	/**
	 * Define um c�digo para fazer refer�ncia ao pagamento. Este c�digo fica associado � transa��o criada pelo pagamento e � �til para vincular as transa��es do PagSeguro �s vendas registradas no seu sistema.
		Presen�a: Opcional.
		Tipo: Texto.
		Formato: Livre, com o limite de 200 caracteres.
	 */
	public String getReference() {
		return reference;
	}
	
	/**
	 * Define um c�digo para fazer refer�ncia ao pagamento. Este c�digo fica associado � transa��o criada pelo pagamento e � �til para vincular as transa��es do PagSeguro �s vendas registradas no seu sistema.
		Presen�a: Opcional.
		Tipo: Texto.
		Formato: Livre, com o limite de 200 caracteres.
	 * @throws Exception 
	 */
	public void setReference(String reference) throws Exception {
		if(reference.length() <= 200){
			this.reference = reference;
		}else {
			 throw new Exception("O numero maximo de caracter permitido e 200");
		}
	}

	/**
	 * Dados do comprador, nome, telefone, email
	 * */
	public Sender getSender() {
		return sender;
	}

	/**
	 * Dados do comprador, nome, telefone, email
	 * */
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	public Checkout ConvertDTOCompraToCheckout(DTOCompra dtoCompra) throws Exception{
		
		Checkout checkout = new Checkout();
		Sender sender = new Sender();
		Item itemCompra = new Item();
		//Phone phone = new Phone();
		
		try{
			
			//realizando preechimento do objeto sender
			sender.setEmail(dtoCompra.getEmailComprador());
			sender.setName(dtoCompra.getNomeComprado());
			//realizando preenchimento do objeto phone
			//phone.setAreacode(dtoCompra.getTelefone().getPrefixo());
			//phone.setAreacode(dtoCompra.getTelefone().getNumero());
			//sender.setPhone(phone);
			//realizando preenchimento do objeto item
			//itemCompra.setId(dtoCompra.getIdServico());
			List<Item> itens = new ArrayList<Item>();
			itemCompra.setId("1");
			itemCompra.setDescription(dtoCompra.getDescricao());
			itemCompra.setAmount(10.90);
			itemCompra.setWeight(0.0);
			itens.add(itemCompra);
			
			//realizando o preenchimento do objeto chockout
			checkout.setReference(dtoCompra.getCodigoReferencia());
			checkout.setId(1);
			checkout.setSender(sender);
			checkout.setItems(itens);
			
		}catch(Exception erro){
			throw new Exception("");
		}
		return checkout;
	}
	
}
