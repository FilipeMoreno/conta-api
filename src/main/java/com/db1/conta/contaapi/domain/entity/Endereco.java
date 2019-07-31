package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Endereco {
	
	public static final String CEP_INVALIDO = "CEP inválido";
	public static final String CEP_OBRIGATORIO = "CEP é obrigatório";
	public static final String TIPO_ENDERECO_OBRIGATORIO = "Tipo de endereço é obrigatório";
	public static final String CIDADE_OBRIGATORIA = "Cidade é obrigatória";
	public static final String NUMERO_OBRIGATORIO = "Número é obrigatório";
	public static final String CLIENTE_OBRIGATORIO = "Cliente é obrigatório";
	public static final String LOGRADOURO_OBRIGATORIO = "Logradouro é obrigatório";
	private Cliente cliente;
	private String logradouro;
	private String numero;
	private Cidade cidade; 
	private String complemento;
	private TipoEndereco tipoEndereco;
	private Long id;
	private String cep;
	
	public Endereco(Cliente cliente, String logradouro, String numero, Cidade cidade, String complemento, TipoEndereco tipoEndereco, String cep) {
		Assert.hasText(logradouro, LOGRADOURO_OBRIGATORIO);
		Assert.notNull(cliente, CLIENTE_OBRIGATORIO);
		Assert.hasText(numero, NUMERO_OBRIGATORIO);
		Assert.notNull(cidade, CIDADE_OBRIGATORIA);
		Assert.notNull(tipoEndereco, TIPO_ENDERECO_OBRIGATORIO);
		Assert.hasText(cep, CEP_OBRIGATORIO);
		Assert.isTrue(cep.length()== 8, CEP_INVALIDO);
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.complemento = complemento;
		this.tipoEndereco = tipoEndereco;
		this.cep = cep;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	
	public String getCep() {
		return cep;
	}
}
