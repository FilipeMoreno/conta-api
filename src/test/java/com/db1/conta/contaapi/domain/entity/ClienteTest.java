package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {
	
	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		try {
			Cliente cliente = new Cliente("00000000000", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Cliente.NOME_É_OBRIGATÓRIO, mensagem);
	}
	
	@Test
	public void deveRetornarCPFObrigatorio() {
		String mensagem = null;
		try {
			Cliente cliente = new Cliente(null, "Cliente");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Cliente.CPF_É_OBRIGATÓRIO, mensagem);
	}
	
	@Test
	public void deveRetornarCPFInvalido() {
		String mensagem = null;
		try {
			Cliente cliente = new Cliente("1234", "Cliente");
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Cliente.CPF_INVÁLIDO, mensagem);
	}
	
	@Test
	public void deveCriarCliente() {
		String mensagem = null;
		Cliente cliente = null;
		try {
			cliente = new Cliente("00000000000", "Cliente");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("00000000000", cliente.getCpf());
		Assert.assertEquals("Cliente", cliente.getNome());
	}

}
