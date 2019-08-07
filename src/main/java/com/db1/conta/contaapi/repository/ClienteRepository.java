package com.db1.conta.contaapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db1.conta.contaapi.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByNome (String nome);
	Cliente findByCpf (String string);
	
	@Query(nativeQuery = true, value = "select * from cliente where nome = :nome")
	Optional<Cliente> findByNomeOptional(@Param("nome") String nome);
	
	@Query(nativeQuery = true, value = "select * from cliente where cpf = :cpf")
	Optional<Cliente> findByCFPOptional(@Param("cpf") String cpf);

}
