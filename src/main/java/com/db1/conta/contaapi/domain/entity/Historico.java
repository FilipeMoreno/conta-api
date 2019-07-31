package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import org.springframework.util.Assert;

public class Historico {
	
	public static final String VALOR_RESULTANTE_OBRIGATORIO = "Valor resultante é obrigatório";
	public static final String CONTA_OBRIGATORIA = "Conta é obrigatória";
	public static final String VALOR_OBRIGATORIO = "Valor é obrigatório";
	public static final String TIPO_HISTORICO_OBRIGATORIO = "Tipo do histórico é obrigatório";
	private Long id;
	private HistoricoTipo tipo;
	private LocalDateTime data;
	private Double valor;
	private Conta conta;
	private Double valorResultante;
	
	public Historico(HistoricoTipo tipo, Double valor, Conta conta, Double valorResultante) {
		Assert.notNull(tipo, TIPO_HISTORICO_OBRIGATORIO);
		Assert.notNull(valor, VALOR_OBRIGATORIO);
		Assert.notNull(conta, CONTA_OBRIGATORIA);
		Assert.notNull(valorResultante, VALOR_RESULTANTE_OBRIGATORIO);
		
		this.tipo = tipo;
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
