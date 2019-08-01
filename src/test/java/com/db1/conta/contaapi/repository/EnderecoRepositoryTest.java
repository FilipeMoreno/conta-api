package com.db1.conta.contaapi.repository;

import static org.junit.Assert.assertEquals;

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
import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTest {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		enderecoRepository.deleteAll();
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmEndereco() {
		
		Cliente cliente = new Cliente("12345678912", "Filipe Moreno");
		Cliente clienteSalvo = clienteRepository.save(cliente);
		Assert.assertNotNull(clienteSalvo);
		
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		Cidade cidadeSalva = cidadeRepository.save(cidade);
		
		Endereco endereco = new Endereco(cliente, "Rua teste", "123", cidadeSalva, null, TipoEndereco.Residencial, "00000000");
		Endereco enderecoSalvo = enderecoRepository.save(endereco);
		
		Assert.assertEquals(endereco.getCep(), enderecoSalvo.getCep());
		Assert.assertEquals(endereco.getComplemento(), enderecoSalvo.getComplemento());
		Assert.assertEquals(endereco.getLogradouro(), enderecoSalvo.getLogradouro());
		Assert.assertEquals(endereco.getCidade(), enderecoSalvo.getCidade());
		Assert.assertEquals(endereco.getCliente(), enderecoSalvo.getCliente());
		Assert.assertEquals(endereco.getTipoEndereco(), enderecoSalvo.getTipoEndereco());
		Assert.assertEquals(endereco.getNumero(), enderecoSalvo.getNumero());
	}
	
	

}
