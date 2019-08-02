package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveCriarUmCliente() {
		
		Cliente cliente = new Cliente("Cliente Teste", "12345678912");
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
	}
	
	@Test
	public void deveSalvarClienteComEndereco() {
		
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		
		Cliente cliente = new Cliente("Cliente Teste", "12345678912");
		cliente.addEndereco("Rua teste", "123", cidade, null, TipoEndereco.Residencial, "00000000");
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
		Assert.assertEquals(1, clienteSalvo.getEnderecos().size());
		Assert.assertNotNull(clienteSalvo.getEnderecos().get(0).getId());
	}
	
	@Test
	public void deveBuscarUmClientePeloNome() {
		
		Cliente cliente = new Cliente("Cliente Teste", "12345678912");
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		Cliente clientePeloNome = clienteRepository.findByNome("Cliente Teste");
		
		Assert.assertNotNull(clienteSalvo.getId());
		Assert.assertNotNull(clientePeloNome);
		Assert.assertEquals(clientePeloNome.getNome(), cliente.getNome());
		Assert.assertEquals(clientePeloNome.getCpf(), cliente.getCpf());
	}
	
	@Test
	public void deveBuscarUmClientePeloCPF() {
		
		Cliente cliente = new Cliente("Cliente Teste", "12345678912");
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		Cliente clientePeloCPF = clienteRepository.findByCpf("12345678912");
		
		Assert.assertNotNull(clientePeloCPF);
		Assert.assertEquals(clientePeloCPF.getNome(), cliente.getNome());
		Assert.assertEquals(clientePeloCPF.getCpf(), cliente.getCpf());
	}

}
