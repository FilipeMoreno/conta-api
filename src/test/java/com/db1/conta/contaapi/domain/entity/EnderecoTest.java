package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

public class EnderecoTest {
	
	@Test
	public void deveRetornarLogradouroObrigatorio() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = new Endereco(cliente, null, "12", cidade, "teste", TipoEndereco.Comercial, "00000000");
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.LOGRADOURO_OBRIGATORIO, mensagem);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = new Endereco(cliente, "Rua aaa", null, cidade, "teste", TipoEndereco.Comercial, "00000000");
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.NUMERO_OBRIGATORIO, mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatoria() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Endereco endereco = new Endereco(cliente, "Rua aaaa", "12", null, "teste", TipoEndereco.Comercial, "00000000");
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.CIDADE_OBRIGATORIA, mensagem);
	}
	
	@Test
	public void deveRetornarClienteObrigatorio() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = new Endereco(null, "Rua aaaa", "12", cidade, "teste", TipoEndereco.Comercial, "00000000");
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.CLIENTE_OBRIGATORIO, mensagem);
	}
	
	@Test
	public void deveRetornarTipoEnderecoObrigatorio() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = new Endereco(cliente, "Rua aaaa", "12", cidade, "teste", null, "00000000");
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.TIPO_ENDERECO_OBRIGATORIO, mensagem);
	}
	
	@Test
	public void deveRetornarCEPObrigatorio() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = new Endereco(cliente, "Rua aaaa", "12", cidade, "teste", TipoEndereco.Comercial, null);
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.CEP_OBRIGATORIO, mensagem);
	}
	
	@Test
	public void deveRetornarCEPInvalido() {
	String mensagem = null;
	try {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		Endereco endereco = new Endereco(cliente, "Rua aaaa", "12", cidade, "teste", TipoEndereco.Comercial, "09");
	} catch (Exception e) {
		mensagem = e.getMessage();
	}
		Assert.assertEquals(Endereco.CEP_INVALIDO, mensagem);
	}
	
	@Test
	public void deveCriarEndereco() {
		String mensagem = null;
		Endereco endereco = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			endereco = new Endereco(cliente, "Rua aaaa", "12", cidade, "teste", TipoEndereco.Comercial, "00000000");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
			Assert.assertNull(mensagem);
			Assert.assertEquals("Rua aaaa", endereco.getLogradouro());
			Assert.assertEquals("12", endereco.getNumero());
			Assert.assertEquals(cliente, endereco.getCliente());
			Assert.assertEquals(TipoEndereco.Comercial, endereco.getTipoEndereco());
			Assert.assertEquals(cidade, endereco.getCidade());
			Assert.assertEquals("teste", endereco.getComplemento());
	}
}
	




