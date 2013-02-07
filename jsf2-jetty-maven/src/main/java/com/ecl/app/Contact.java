package com.ecl.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name="tb_contact")  
public class Contact {
	
	@GeneratedValue
	@Id
	private Long Id;

	private String nome;
	private String email;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return this.nome + " " + this.email;
	}
}
