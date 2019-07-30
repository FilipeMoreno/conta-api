package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	
	private Long id;
	private Agencia agencia;
	private ContaTipo tipo;
	private String numero;
	private Cliente cliente;
	private Double saldo;
	private List<Historico> historicos = new ArrayList<Historico>();
	
	public Conta (Agencia agencia, ContaTipo tipo, String numero, Cliente cliente, Double saldo) {
		
		this.agencia = agencia;
		this.tipo = tipo;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public List<Historico> getHistoricos() {
		return historicos;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public ContaTipo getTipo() {
		return tipo;
	}

}
