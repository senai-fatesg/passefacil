package br.com.sisfacil.passefacil.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAttribute;

import sun.net.www.URLConnection;
import br.com.sisfacil.passefacil.dto.DTOCompra;
import br.com.sisfacil.passefacil.entidade.compra.Checkout;
import br.com.sisfacil.passefacil.entidade.compra.Item;
import br.com.sisfacil.passefacil.entidade.compra.Phone;
import br.com.sisfacil.passefacil.entidade.compra.Sender;

@Path("/comprar")
public class ServiceComprar {

	
	private Checkout checkout;
	static private Map<Integer, Checkout> checkoutEnvioMap;
	private static DTOCompra compra = new DTOCompra();
	
	@Path("/postComprar")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String postComprar(String objetoRecebido){
		try {
		
			String token = "cole aqui o token do vendedor";
			StringBuffer validaNPI = new StringBuffer("Comando=validar&Token=");
			validaNPI.append(token);
			
			
			URL u = new URL("https://sandbox.pagseguro.uol.com.br/pagseguro-ws/checkout/NPI.jhtml");
			URLConnection uc = (URLConnection) u.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(validaNPI.toString());
			pw.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String res = in.readLine();
			in.close();

			
		} catch (Exception e) {
			
		}
				
		return "";
	}
	
	
	
	@Path("/obterXmlCompra")
	@GET
	@Produces("text/xml")
	public ArrayList<DTOCompra> obterXmlCompra(){
		return new ArrayList<DTOCompra>(dtoCompraMap.values());
	}
	
	static private Map<Integer, DTOCompra> dtoCompraMap;

	static {
		dtoCompraMap = new HashMap<Integer, DTOCompra>();
		DTOCompra dtoCompra = new DTOCompra();
		dtoCompra.setBairro("setor universitario");
		dtoCompra.setCep("74610142");
		dtoCompra.setCidade("Goi�nia");
		dtoCompra.setComplemento("setor leste universitario");
		dtoCompra.setDescricao("Uma passagem de onibus");//obrigatorio
		dtoCompra.setEmail("aurelianos18@gmail.com");//obrigatorio
		dtoCompra.setEmailComprador("joao@gmail.com");
		dtoCompra.setEstado("Goias");
		dtoCompra.setCodigoReferencia("P1TB");//obrigatorio
		dtoCompra.setNomeComprado("Joao");
		dtoCompra.setNomeRua("228");
		dtoCompra.setNumeroCasa("28");
		dtoCompra.setNumeroMaximoParacodigoPagamento(800);
		dtoCompra.setPrazoValidadeCodigoPagamento(999999);
		dtoCompra.setQuantidadeItem(1);//obrigatorio
		dtoCompra.setValorUnitarioItem(BigDecimal.valueOf(10.99));//obrigatorio
		dtoCompra.setUrlNotificacao("www.notificacao.com.br");
		dtoCompra.setUrlRedirecionamento("www.redirecionamento.com.br");

		compra = dtoCompra;
		
		dtoCompraMap.put(dtoCompra.getId(), dtoCompra);
	}
	
	
	/**
	
	@Path("/enviarXmlAoPagseguro")
	 * @throws Exception 
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Checkout>enviarXmlAoPagseguro(DTOCompra dtoCompra){
		checkout = new Checkout();
		checkoutEnvioMap.put(checkout.getId(), checkout.ConvertDTOCompraToCheckout(dtoCompra));
		return new ArrayList<Checkout>(checkoutEnvioMap.values());
	}
	
	*/
	
	@Path("/enviarXmlAoPagseguro")
	@GET
	@Produces("text/xml")
	public List<Checkout>enviarXmlAoPagseguro() throws Exception{
		obtenhaCheckot();
		ArrayList<Checkout> arrayCheckout = new ArrayList<Checkout>();
		arrayCheckout = new ArrayList<Checkout>(checkoutEnvioMap.values());
		$xml.annotationType();
		return arrayCheckout; 
	}
	
	/**
	 
	 static {
		checkoutEnvioMap = new HashMap<Integer, Checkout>();
		Checkout checkout=new Checkout();
		checkout.setId(1);
		List<Item>items = new ArrayList<Item>();
		Item item = new Item();
		item.setAmount(100);
		try {
			item.setDescription("compra de credito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		item.setId("1");
		item.setWeight(0.0);
		items.add(item);
		checkout.setItems(items);
		Sender sender = new Sender();
		sender.setEmail("aureliano.silva@gmail.com");
		sender.setName("aureliano");
		Phone phone = new Phone();
		phone.setAreacode(62);
		phone.setNumber(99446733);
		sender.setPhone(phone);
		try {
			checkout.setReference("REFPASFACIL");
		} catch (Exception e) {
			e.printStackTrace();
		};
		checkout.setSender(sender);
		
		
		checkoutEnvioMap.put(checkout.getId(), checkout);
	}
	 
	 * */
	private XmlAttribute $xml;
	
	private void obtenhaCheckot(){
		
		checkoutEnvioMap = new HashMap<Integer, Checkout>();
		Checkout checkout=new Checkout();
		checkout.setId(1);
		List<Item>itens = new ArrayList<Item>();
		Item item = new Item();
		item.setAmount(100);
		try {
			item.setDescription("compra de credito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		item.setId("1");
		item.setWeight(0.0);
		//checkout.addItem(item);
		checkout.setItems(itens);
		Sender sender = new Sender();
		sender.setEmail("aureliano.silva@gmail.com");
		sender.setName("aureliano");
		Phone phone = new Phone();
		phone.setAreacode(62);
		phone.setNumber(99446733);
		sender.setPhone(phone);
		try {
			checkout.setReference("REFPASFACIL");
		} catch (Exception e) {
			e.printStackTrace();
		};
		checkout.setSender(sender);
		
		checkoutEnvioMap.put(checkout.getId(), checkout);
	}
	
}
