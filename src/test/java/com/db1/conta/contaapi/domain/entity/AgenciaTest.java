package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Assert;

public class AgenciaTest {
	
	@Test
	public void deveRetornarNumeroObrigatorio() {
		String mensagem = null;
		Cidade cidade = Mockito.mock(Cidade.class);
		try {
			Agencia agencia = new Agencia(null, "2", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Agencia.NÚMERO_É_OBRIGATÓRIO, mensagem);
		
	}
	
	@Test
	public void deveRetornarDigitoObrigatorio() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		try {
			Agencia agencia = new Agencia("1234", null, cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Agencia.DÍGITO_É_OBRIGATÓRIO, mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigadotio() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		try {
			Agencia agencia = new Agencia("1234", "2", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Agencia.CIDADE_É_OBRIGATÓRIO, mensagem);
	}
	
	@Test
	public void deveRetornarAgenciaInvalida() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		try {
			Agencia agencia = new Agencia("123435", "2", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Agencia.NUMERO_INVALIDO, mensagem);
	}
	
	@Test
	public void deveRetornarDigitoInvalido() {
		String mensagem = null;
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		try {
			Agencia agencia = new Agencia("1234", "215", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Agencia.DIGITO_INVALIDO, mensagem);
	}
	
	@Test
	public void deveCriarUmaAgencia() {
		String mensagem = null;
		Agencia agencia = null;
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		try {
			agencia = new Agencia("1234", "2", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("1234", agencia.getNumero());
		Assert.assertEquals("2", agencia.getDigito());
		Assert.assertEquals(cidade, agencia.getCidade());
	}

}
