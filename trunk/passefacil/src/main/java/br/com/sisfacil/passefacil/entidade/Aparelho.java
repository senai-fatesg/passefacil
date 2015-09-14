package br.com.sisfacil.passefacil.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Aparelho {

	@Id
	@GeneratedValue(generator = "aparelho_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "aparelho_seq", sequenceName = "aparelho_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	
	private String imei;
	private EnumStatus status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public EnumStatus getStatus() {
		return status;
	}

	public void setStatus(EnumStatus status) {
		this.status = status;
	}
	
}
