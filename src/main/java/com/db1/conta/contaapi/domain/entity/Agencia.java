package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Agencia {
	
	public static final String DÍGITO_É_OBRIGATÓRIO = "Dígito é obrigatório";
	public static final String CIDADE_É_OBRIGATÓRIO = "Cidade é obrigatória";
	public static final String NÚMERO_É_OBRIGATÓRIO = "Número é obrigatório";
	
	private Long id;
	private String numero;
	private String digito;
	private Cidade Cidade;
	private List<Historico> historicos = new ArrayList<Historico>();
	
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
	
	public List<Historico> getHistoricos() {
		return historicos;
	}

}
