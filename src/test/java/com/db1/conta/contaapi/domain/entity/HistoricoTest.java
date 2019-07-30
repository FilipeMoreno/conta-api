package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

public class HistoricoTest {
	
	@Test
	public void deveRetornarTipoObrigatorio() {
		String mensagem = null;
		try {
			Conta conta = Mockito.mock(Conta.class);
			Historico historico = new Historico(null, 100.0, conta, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Tipo do histórico é obrigatório", mensagem);
		
	}
	
	@Test
	public void deveRetornarContaObrigatoria() {
		String mensagem = null;
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, 100.0, null, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Conta é obrigatória", mensagem);
		
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		String mensagem = null;
		try {
			Conta conta = Mockito.mock(Conta.class);
			Historico historico = new Historico(HistoricoTipo.Entrada, null, conta, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor é obrigatório", mensagem);
		
	}
	
	@Test
	public void deveRetornarValorResultante() {
		String mensagem = null;
		try {
			Conta conta = Mockito.mock(Conta.class);
			Historico historico = new Historico(HistoricoTipo.Entrada, 100.0, conta, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Valor resultante é obrigatório", mensagem);
		
	}

}
