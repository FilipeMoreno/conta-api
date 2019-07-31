package com.db1.conta.contaapi.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaRepositoryTest {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		agenciaRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaAgencia() {
		
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		Cidade cidadeSalva = cidadeRepository.save(cidade);
		Assert.assertNotNull(cidade);
		
		Agencia agencia = new Agencia("1234", "0", cidade);
		Agencia agenciaSalva = agenciaRepository.save(agencia);
		
		Assert.assertNotNull(cidade.getId());
		Assert.assertNotNull(agenciaSalva.getId());
		Assert.assertEquals(agencia.getNumero(), agenciaSalva.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaSalva.getDigito());
		Assert.assertEquals(cidade.getId(), agenciaSalva.getCidade().getId());
		
	}
	
	@Test
	public void deveBuscarUmaAgenciaPeloNumero() {
		
		Cidade cidade = new Cidade("Maringá", Estado.PR);
		Cidade cidadeSalva = cidadeRepository.save(cidade);
		Assert.assertNotNull(cidade);
		
		Agencia agencia = new Agencia("1234", "0", cidade);
		Agencia agenciaSalva = agenciaRepository.save(agencia);
		
		Agencia agenciaPeloNumero = agenciaRepository.findByNumero("1234");
		
		Assert.assertNotNull(agenciaPeloNumero);
		Assert.assertEquals(agencia.getNumero(), agenciaPeloNumero.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaPeloNumero.getDigito());
		Assert.assertEquals(cidade.getId(), agenciaPeloNumero.getCidade().getId());	
	}
	
//	@Test
//	public void deveBuscarTodasAgenciasDeUmEstado() {
//		
//		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
//		
//		Agencia agencia = new Agencia("0506", "1", cidade);
//		
//		Agencia agenciaSalva = agenciaRepository.save(agencia);
//		
//		List<Agencia> agencias = agenciaRepository.findByCidadeEstado(Estado.PR);
//		
//		Assert.assertEquals(1, agencias.size());
//	}
	
}
