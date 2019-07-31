package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Cidade {

	public static final String ESTADO_É_OBRIGATÓRIO = "Estado é obrigatório";

	public static final String NOME_É_OBRIGATÓRIO = "Nome é obrigatório";

	private Long id;
	
	private String nome;
	
	private Estado estado;
	
	public Cidade(String nome, Estado estado) {
		Assert.hasText(nome, NOME_É_OBRIGATÓRIO);
		Assert.notNull(estado, ESTADO_É_OBRIGATÓRIO);
		this.nome = nome;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Estado getEstado() {
		return estado;
	}
}
