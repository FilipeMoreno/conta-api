package com.db1.conta.contaapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	
	Optional<Cidade> findByNomeDTO(String nome);
	
	Optional<Cidade> findByEstadoDTO(Estado estado);

	Cidade findByNome(String nome);
	
	List<Cidade> findByEstado(Estado estado);
}
