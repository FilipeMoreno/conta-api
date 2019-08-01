package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	public static final String CPF_INVÁLIDO = "CPF inválido";
	public static final String CPF_É_OBRIGATÓRIO = "CPF é obrigatório";
	public static final String NOME_É_OBRIGATÓRIO = "Nome é obrigatório";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "nome", length = 120, nullable = false, unique = true)
	private String nome;
	
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinTable(name="cliente_enderecos",
	             joinColumns={@JoinColumn(name = "cliente_id")},
	             inverseJoinColumns={@JoinColumn(name = "endereco_id")})
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Conta> contas = new ArrayList<>();
	
	protected Cliente() {}
	
	public Cliente(String cpf, String nome) {
		Assert.hasText(nome, NOME_É_OBRIGATÓRIO);
		Assert.hasText(cpf, CPF_É_OBRIGATÓRIO);
		Assert.isTrue(cpf.length() == 11, CPF_INVÁLIDO);
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public List<Conta> getContas() {
		return contas;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

}
