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
		Assert.assertEquals("Número é obrigatório", mensagem);
		
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
		Assert.assertEquals("Dígito é obrigatório", mensagem);
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
		Assert.assertEquals("Cidade é obrigatório", mensagem);
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
