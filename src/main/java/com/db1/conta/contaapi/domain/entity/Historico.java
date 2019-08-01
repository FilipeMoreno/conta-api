package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.util.Assert;

@Embeddable
public class Historico {
	
	public static final String VALOR_RESULTANTE_OBRIGATORIO = "Valor resultante é obrigatório";
	public static final String CONTA_OBRIGATORIA = "Conta é obrigatória";
	public static final String VALOR_OBRIGATORIO = "Valor é obrigatório";
	public static final String TIPO_HISTORICO_OBRIGATORIO = "Tipo do histórico é obrigatório";

	@Column(name="tipo")
	private HistoricoTipo tipo;
	
	@Column(name="data")
	private LocalDateTime data;
	
	@Column(name="valor")
	private Double valor;

	@Column(name="valor_resultante")
	private Double valorResultante;
	
	public Historico(HistoricoTipo tipo, Double valor, Double valorResultante) {
		Assert.notNull(tipo, TIPO_HISTORICO_OBRIGATORIO);
		Assert.notNull(valor, VALOR_OBRIGATORIO);
		Assert.notNull(valorResultante, VALOR_RESULTANTE_OBRIGATORIO);
		
		this.tipo = tipo;
		this.valor = valor;
		this.valorResultante = valorResultante;
		
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
		return valorResultante;
	}
	

}
