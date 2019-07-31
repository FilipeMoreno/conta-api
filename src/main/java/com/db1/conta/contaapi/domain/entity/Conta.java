package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Conta {
	
	public static final String SALDO_OBRIGATORIO = "Saldo é obrigatório";
	public static final String CLIENTE_OBRIGATORIO = "Cliente é obrigatório";
	public static final String NUMERO_CONTA_OBRIGATORIO = "Número da conta é obrigatório";
	public static final String TIPO_CONTA_OBRIGATORIO = "Tipo de conta é obrigatório";
	public static final String AGENCIA_OBRIGATORIA = "Agência é obrigatória";
	private Long id;
	private Agencia agencia;
	private ContaTipo tipo;
	private String numero;
	private Cliente cliente;
	private Double saldo;
	private List<Historico> historicos = new ArrayList<Historico>();
	
	public Conta (Agencia agencia, ContaTipo tipo, String numero, Cliente cliente, Double saldo) {
		
		Assert.notNull(agencia, AGENCIA_OBRIGATORIA);
		Assert.notNull(tipo, TIPO_CONTA_OBRIGATORIO);
		Assert.notNull(numero, NUMERO_CONTA_OBRIGATORIO);
		Assert.notNull(cliente, CLIENTE_OBRIGATORIO);
		Assert.notNull(saldo, SALDO_OBRIGATORIO);
		
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
