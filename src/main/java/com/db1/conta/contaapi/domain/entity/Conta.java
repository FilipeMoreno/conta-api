package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.db1.conta.contaapi.infra.Verificadora;

@Entity
@Table(name = "conta")
public class Conta {
	
	private static final String DEPOSITO_VALOR_DEVE_SER_MAIOR_QUE_ZERO = "Valor a ser depositado deve ser maior que zero";
	private static final String SAQUE_VALOR_DEVE_SER_MAIOR_QUE_ZERO = "Valor a ser sacado deve ser maior que zero";
	public static final String CLIENTE_OBRIGATORIO = "Cliente é obrigatório";
	public static final String NUMERO_CONTA_OBRIGATORIO = "Número da conta é obrigatório";
	public static final String TIPO_CONTA_OBRIGATORIO = "Tipo de conta é obrigatório";
	public static final String AGENCIA_OBRIGATORIA = "Agência é obrigatória";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private Agencia agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 2, nullable = false)
	private ContaTipo tipo;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "saldo", precision = 14, nullable = false, scale = 2)
	private Double saldo;
	
	@ElementCollection
    @CollectionTable(name="historico", joinColumns=@JoinColumn(name="conta_id"))
	private List<Historico> historicos = new ArrayList<Historico>();
	
	protected Conta() {}
	
	public Conta (Agencia agencia, ContaTipo tipo, String numero, Cliente cliente) {
		
		Assert.notNull(agencia, AGENCIA_OBRIGATORIA);
		Assert.notNull(tipo, TIPO_CONTA_OBRIGATORIO);
		Assert.notNull(numero, NUMERO_CONTA_OBRIGATORIO);
		Assert.notNull(cliente, CLIENTE_OBRIGATORIO);
		
		this.agencia = agencia;
		this.tipo = tipo;
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}
	
	public void depositar(double valor) {	
		
		Verificadora.valorMaiorQueZero(valor, DEPOSITO_VALOR_DEVE_SER_MAIOR_QUE_ZERO);
		this.saldo += valor;
		this.historicos.add(new Historico(HistoricoTipo.Entrada, valor, this.saldo));
	}
	
	public void sacar(double valor) {	
		Verificadora.valorMaiorOuIgualQueZero(valor, SAQUE_VALOR_DEVE_SER_MAIOR_QUE_ZERO);
		this.saldo += valor;
		this.historicos.add(new Historico(HistoricoTipo.Saída, valor, this.saldo));
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
