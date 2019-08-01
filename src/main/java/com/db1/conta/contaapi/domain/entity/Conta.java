package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "conta")
public class Conta {
	
	public static final String SALDO_OBRIGATORIO = "Saldo é obrigatório";
	public static final String CLIENTE_OBRIGATORIO = "Cliente é obrigatório";
	public static final String NUMERO_CONTA_OBRIGATORIO = "Número da conta é obrigatório";
	public static final String TIPO_CONTA_OBRIGATORIO = "Tipo de conta é obrigatório";
	public static final String AGENCIA_OBRIGATORIA = "Agência é obrigatória";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "agencia_id", nullable = false)
	@ManyToOne(optional = false)
	private Agencia agencia;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 2, nullable = false)
	private ContaTipo tipo;
	
	@Column(name = "numero", length = 20, nullable = false, unique = true)
	private String numero;
	
	@JoinColumn(name = "cliente_id", nullable = false)
	@ManyToOne(optional = false)
	private Cliente cliente;
	
	@Column(name = "saldo", length = 20, nullable = false)
	private Double saldo;
	
	@ElementCollection
    @CollectionTable(name="historico", joinColumns=@JoinColumn(name="cliente_id"))
	private List<Historico> historicos = new ArrayList<Historico>();
	
	protected Conta() {}
	
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
