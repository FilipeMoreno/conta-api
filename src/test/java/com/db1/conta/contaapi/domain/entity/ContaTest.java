package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;

public class ContaTest {
	
	@Test
	public void deveRetornarAgenciaObrigatoria() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		try {
			Conta conta = new Conta(null, ContaTipo.Corrente, "123", cliente, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Agência é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarTipoObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, null, "123", cliente, 100.0);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Tipo de conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarNumeroContaObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, ContaTipo.Poupança, null, cliente, 100.0);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		String mensagem = null;
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, ContaTipo.Corrente, "123", null, 100.0);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarSaldoObrigatorio() {
		String mensagem = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			Conta conta = new Conta(agencia, ContaTipo.Corrente, "123", cliente, null);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarConta() {
		String mensagem = null;
		Conta conta = null;
		Cliente cliente = Mockito.mock(Cliente.class);
		Agencia agencia = Mockito.mock(Agencia.class);
		try {
			conta = new Conta(agencia, ContaTipo.Corrente, "1234", cliente, 0.0);
		} catch (Exception e){
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(agencia, conta.getAgencia());
		Assert.assertEquals(ContaTipo.Corrente, conta.getTipo());
		Assert.assertEquals("1234", conta.getNumero());
		Assert.assertEquals(cliente, conta.getCliente());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0);
	}

}
