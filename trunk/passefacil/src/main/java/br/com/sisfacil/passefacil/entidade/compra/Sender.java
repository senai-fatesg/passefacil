package br.com.sisfacil.passefacil.entidade.compra;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sender { //Dados do comprador.

	private String name; //nome do comprador
	private String email; //email do comprador
	private Phone phone; //telefone do comprador
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}
