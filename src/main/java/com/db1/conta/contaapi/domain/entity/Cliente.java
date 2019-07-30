package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Cliente {
	
	private Long id;
	private String cpf;
	private String nome;
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	private List<Conta> contas = new ArrayList<>();
	
	public Cliente(String cpf, String nome) {
		Assert.hasText(nome, "Nome inválido");
		Assert.hasText(cpf, "CPF inválido");
		Assert.isTrue(cpf.length() == 11, "CPF inválido");
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
