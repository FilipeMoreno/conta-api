package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

public class HistoricoTest {
	
	@Test
	public void deveRetornarDataObrigatoria() {
		String mensagem = null;
		Historico historico = null;
		try {
			Conta conta = Mockito.mock(Conta.class);
			historico = new Historico(HistoricoTipo.Entrada, null, 100.0, conta, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Data é obrigatória", mensagem);
		
	}
	
//	@Test
//	public void deveRetornarTipoObrigatorio() {
//		String mensagem = null;
//		try {
//			Conta conta = Mockito.mock(Conta.class);
//			Historico historico = new Historico(null, 2019-07-30, 100.0, conta, 100.0);
//		} catch (Exception e) {
//			mensagem = e.getMessage();
//		}
//		Assert.assertEquals("Data é obrigatória", mensagem);
//		
//	}
//	
//	@Test
//	public void deveRetornarContaObrigatoria() {
//		String mensagem = null;
//		try {
//			Historico historico = new Historico(HistoricoTipo.Entrada, 2019-07-30, 100.0, null, 100.0);
//		} catch (Exception e) {
//			mensagem = e.getMessage();
//		}
//		Assert.assertEquals("Conta é obrigatória", mensagem);
//		
//	}
//	
//	@Test
//	public void deveRetornarValorObrigatorio() {
//		String mensagem = null;
//		try {
//			Conta conta = Mockito.mock(Conta.class);
//			Historico historico = new Historico(HistoricoTipo.Entrada, (2016, 1, 5), null, conta, 100.0);
//		} catch (Exception e) {
//			mensagem = e.getMessage();
//		}
//		Assert.assertEquals("Valor é obrigatório", mensagem);
//		
//	}
//	
//	@Test
//	public void deveRetornarValorResultante() {
//		String mensagem = null;
//		try {
//			Conta conta = Mockito.mock(Conta.class);
//			Historico historico = new Historico(HistoricoTipo.Entrada, 2019-07-30, 100.0, conta, null);
//		} catch (Exception e) {
//			mensagem = e.getMessage();
//		}
//		Assert.assertEquals("Valor resultante é obrigatório", mensagem);
//		
//	}

}
