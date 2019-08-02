package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.ContaTipo;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaRepositoryTest {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@After
	public void afterTest() {
		contaRepository.deleteAll();
		agenciaRepository.deleteAll();
		cidadeRepository.deleteAll();
		clienteRepository.deleteAll();
	}
	
	@Test
	public void deveCriarUmaConta() {
		
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));

		Agencia agencia = agenciaRepository.save(new Agencia("1234", "0", cidade));
		
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Teste", "00000000000"));
		
		Conta conta = new Conta(agencia, ContaTipo.Corrente, "123456", cliente);
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertNotNull(contaSalva.getId());
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
		Assert.assertEquals(conta.getAgencia(), contaSalva.getAgencia());
		Assert.assertEquals(conta.getCliente(), contaSalva.getCliente());
		Assert.assertEquals(conta.getSaldo(), contaSalva.getSaldo());
		Assert.assertEquals(conta.getTipo(), contaSalva.getTipo());
		Assert.assertEquals(0, contaSalva.getHistoricos().size());
	}
	
	@Test
	public void deveSalvarUmaContaEUmHistorico() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = clienteRepository.save(new Cliente("Cliente Teste", "00000000000"));
		Agencia agencia = agenciaRepository.save(new Agencia("1234", "1", cidade));
		
		Conta conta = new Conta(agencia, ContaTipo.Corrente, "1234", cliente);
		conta.depositar(10.0);
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
		Assert.assertNotNull(contaSalva.getId());
		Assert.assertEquals(1,contaSalva.getHistoricos().size());
	}

}
