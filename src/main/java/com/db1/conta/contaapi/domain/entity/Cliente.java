package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Cliente {
	
	public static final String CPF_INVÁLIDO = "CPF inválido";
	public static final String CPF_É_OBRIGATÓRIO = "CPF é obrigatório";
	public static final String NOME_É_OBRIGATÓRIO = "Nome é obrigatório";
	private Long id;
	private String cpf;
	private String nome;
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Conta> contas = new ArrayList<>();
	
	public Cliente(String cpf, String nome) {
		Assert.hasText(nome, NOME_É_OBRIGATÓRIO);
		Assert.hasText(cpf, CPF_É_OBRIGATÓRIO);
		Assert.isTrue(cpf.length() == 11, CPF_INVÁLIDO);
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

}
