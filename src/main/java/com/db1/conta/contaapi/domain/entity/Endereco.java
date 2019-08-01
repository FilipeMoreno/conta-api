package com.db1.conta.contaapi.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	public static final String CEP_INVALIDO = "CEP inválido";
	public static final String CEP_OBRIGATORIO = "CEP é obrigatório";
	public static final String TIPO_ENDERECO_OBRIGATORIO = "Tipo de endereço é obrigatório";
	public static final String CIDADE_OBRIGATORIA = "Cidade é obrigatória";
	public static final String NUMERO_OBRIGATORIO = "Número é obrigatório";
	public static final String CLIENTE_OBRIGATORIO = "Cliente é obrigatório";
	public static final String LOGRADOURO_OBRIGATORIO = "Logradouro é obrigatório";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "cliente_id", nullable = false)
	@ManyToOne
	private Cliente cliente;
	
	@Column(name = "logradouro", length = 60, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 6, nullable = false)
	private String numero;
	
	@JoinColumn(name = "cidade_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Cidade cidade; 
	
	@Column(name = "complemento", length = 60)
	private String complemento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_endereco", length = 15, nullable = false)
	private TipoEndereco tipoEndereco;
	
	@Column(name = "cep", length = 8, nullable = false)
	private String cep;
	
	protected Endereco() {}
	
	public Endereco(Cliente cliente, String logradouro, String numero, Cidade cidade, String complemento, TipoEndereco tipoEndereco, String cep) {
		Assert.hasText(logradouro, LOGRADOURO_OBRIGATORIO);
		Assert.notNull(cliente, CLIENTE_OBRIGATORIO);
		Assert.hasText(numero, NUMERO_OBRIGATORIO);
		Assert.notNull(cidade, CIDADE_OBRIGATORIA);
		Assert.notNull(tipoEndereco, TIPO_ENDERECO_OBRIGATORIO);
		Assert.hasText(cep, CEP_OBRIGATORIO);
		Assert.isTrue(cep.length()== 8, CEP_INVALIDO);
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.complemento = complemento;
		this.tipoEndereco = tipoEndereco;
		this.cep = cep;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	
	public String getCep() {
		return cep;
	}
}
