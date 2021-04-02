package com.example.api.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_address")
	private Long id;
	
	
	private String cep;

	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="customer_id")
    private Customer id_customer;
	
	
	public Address() {	
		
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	
	
	public String getLocalidade() {
		return localidade;
	}



	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}



	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Customer getId_customer() {
		return id_customer;
	}

	public void setId_customer(Customer id_customer) {
		this.id_customer = id_customer;
	}



	
	

	
	
}
