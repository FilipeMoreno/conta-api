package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	public static final String DIGITO_OBRIGATORIO = "Dígito é obrigatório";
	public static final String CIDADE_OBRIGATORIA = "Cidade é obrigatória";
	public static final String NUMERO_OBRIGATORIO = "Número é obrigatório";
	public static final String NUMERO_INVALIDO = "Número da agência é inválido";
	public static final String DIGITO_INVALIDO = "Dígito da agência é inválido";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero", length = 4, nullable = false, unique = true)
	private String numero;
	
	@Column(name = "digito", length = 1, nullable = false)
	private String digito;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;
	
	protected Agencia () {}
	
	public Agencia(String numero, String digito, Cidade cidade) {
		this.validarAgencia(numero, digito, cidade);
		this.numero = numero;
		this.digito = digito;
		this.cidade = cidade;
	}
	
	public void alterarAgencia(String numero, String digito, Cidade cidade) {
		this.validarAgencia(numero, digito, cidade);
		this.numero = numero;
		this.digito = digito;
		this.cidade = cidade;
	}
	
	public void validarAgencia(String numero, String digito, Cidade cidade) {
		Assert.hasText(numero, NUMERO_OBRIGATORIO);
		Assert.notNull(cidade, CIDADE_OBRIGATORIA);
		Assert.hasText(digito, DIGITO_OBRIGATORIO);
		Assert.isTrue(numero.length() == 4, NUMERO_INVALIDO);
		Assert.isTrue(digito.length() == 1, DIGITO_INVALIDO);
	}
	
	public Cidade getCidade() {
		return cidade;
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
