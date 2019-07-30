package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Agencia {
	
	private Long id;
	private String numero;
	private String digito;
	private Cidade Cidade;
	private List<Historico> historicos = new ArrayList<Historico>();
	
	public Agencia(String numero, String digito, Cidade cidade) {
		Assert.hasText(numero, "Número é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatório");
		Assert.hasText(digito, "Dígito é obrigatório");
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
