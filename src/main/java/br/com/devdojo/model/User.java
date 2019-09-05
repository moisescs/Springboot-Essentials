package br.com.devdojo.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User extends AbstractEntity{
	@NotBlank
	@Column(unique = true)
	private String userName;
	
	@NotBlank
	@JsonIgnore
	private String password;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private boolean admin;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
