package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "agencia")
public class Agencia {
	
	public static final String DÍGITO_É_OBRIGATÓRIO = "Dígito é obrigatório";
	public static final String CIDADE_É_OBRIGATÓRIO = "Cidade é obrigatória";
	public static final String NÚMERO_É_OBRIGATÓRIO = "Número é obrigatório";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero", length = 4, nullable = false, unique = true)
	private String numero;
	
	@Column(name = "digito", length = 1, nullable = false)
	private String digito;
	
	@JoinColumn(name = "cidade_id", nullable = false)
	@ManyToOne(optional = false)
	private Cidade Cidade;
	
	protected Agencia () {}
	
	public Agencia(String numero, String digito, Cidade cidade) {
		Assert.hasText(numero, NÚMERO_É_OBRIGATÓRIO);
		Assert.notNull(cidade, CIDADE_É_OBRIGATÓRIO);
		Assert.hasText(digito, DÍGITO_É_OBRIGATÓRIO);
		this.numero = numero;
		this.digito = digito;
		this.Cidade = cidade;
	}
	
	public Cidade getCidade() {
		return Cidade;
	}
	
	public String getDigito() {
		return digito;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNumero() {
		return numero;
	}

}
