package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import org.springframework.util.Assert;

public class Historico {
	
	private Long id;
	private HistoricoTipo tipo;
	private LocalDateTime data;
	private Double valor;
	private Conta conta;
	private Double valorResultante;
	
	public Historico(HistoricoTipo tipo, Double valor, Conta conta, Double valorResultante) {
		Assert.notNull(tipo, "Tipo do histórico é obrigatório");
		Assert.notNull(valor, "Valor é obrigatório");
		Assert.notNull(conta, "Conta é obrigatória");
		Assert.notNull(valorResultante, "Valor resultante é obrigatório");
		
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
		this.conta = conta;
		this.valorResultante = valorResultante;
		
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public Long getId() {
		return id;
	}
	
	public HistoricoTipo getTipo() {
		return tipo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public Double getValorResultante() {
		return valorResultante;
	}
	

}
