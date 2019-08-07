package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

import com.db1.conta.contaapi.domain.entity.Cidade;

public class AgenciaResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numero;
	private String digito;
	private Cidade cidade;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDigito() {
		return digito;
	}
	public void setDigito(String digito) {
		this.digito = digito;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
