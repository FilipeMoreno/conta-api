package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.util.Assert;

@Embeddable
public class Historico {
	
	public static final String SALDO_ATUAL_OBRIGATORIO = "Saldo atual é obrigatório";
	public static final String CONTA_OBRIGATORIA = "Conta é obrigatória";
	public static final String VALOR_OBRIGATORIO = "Valor é obrigatório";
	public static final String TIPO_HISTORICO_OBRIGATORIO = "Tipo do histórico é obrigatório";

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false, length = 30)
	private HistoricoTipo tipo;
	
	@Column(name = "data", nullable = false, length = 30)
	private LocalDateTime data;
	
	@Column(name = "valor", nullable = false, precision = 14, scale = 2)
	private Double valor;

	@Column(name = "saldo_atual", nullable = false, precision = 14, scale = 2)
	private Double saldoAtual;
	
	protected Historico() {}
	
	public Historico(HistoricoTipo tipo, Double valor, Double saldoAtual) {
		Assert.notNull(tipo, TIPO_HISTORICO_OBRIGATORIO);
		Assert.notNull(valor, VALOR_OBRIGATORIO);
		Assert.notNull(saldoAtual, SALDO_ATUAL_OBRIGATORIO);
		
		this.tipo = tipo;
		this.valor = valor;
		this.saldoAtual = saldoAtual;
		this.data = LocalDateTime.now();
		
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public HistoricoTipo getTipo() {
		return tipo;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public Double getValorResultante() {
		return saldoAtual;
	}
	

}
