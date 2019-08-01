package com.db1.conta.contaapi.domain.entity;

import org.junit.Test;
import org.mockito.Mockito;
import org.junit.Assert;

public class HistoricoTest {
	
	@Test
	public void deveRetornarTipoObrigatorio() {
		String mensagem = null;
		try {
			Historico historico = new Historico(null, 100.0, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Historico.TIPO_HISTORICO_OBRIGATORIO, mensagem);
		
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		String mensagem = null;
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, null, 100.0);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Historico.VALOR_OBRIGATORIO, mensagem);
	}
	
	@Test
	public void deveRetornarValorResultante() {
		String mensagem = null;
		try {
			Historico historico = new Historico(HistoricoTipo.Entrada, 100.0, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals(Historico.SALDO_ATUAL_OBRIGATORIO, mensagem);
	}

}
