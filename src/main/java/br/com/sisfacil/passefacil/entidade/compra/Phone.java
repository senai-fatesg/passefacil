package br.com.sisfacil.passefacil.entidade.compra;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Phone {

	private int areacode; //prefixo do telefone
	private int number; //numero do telefone
	public int getAreacode() {
		return areacode;
	}
	public void setAreacode(int areacode) {
		this.areacode = areacode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
