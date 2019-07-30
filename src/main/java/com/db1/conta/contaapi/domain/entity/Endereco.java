package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Endereco {
	
	private Cliente cliente;
	private String logradouro;
	private String numero;
	private Cidade cidade; 
	private String complemento;
	private TipoEndereco tipoEndereco;
	private Long id;
	private String cep;
	
	public Endereco(Cliente cliente, String logradouro, String numero, Cidade cidade, String complemento, TipoEndereco tipoEndereco, String cep) {
		Assert.hasText(logradouro, "Logradouro é obrigatório");
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.hasText(numero, "Número é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatória");
		Assert.notNull(tipoEndereco, "Tipo de endereço é obrigatório");
		Assert.hasText(cep, "CEP é obrigatório");
		Assert.isTrue(cep.length()== 8, "CEP inválido");
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
