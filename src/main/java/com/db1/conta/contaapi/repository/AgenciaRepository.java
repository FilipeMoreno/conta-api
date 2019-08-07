package com.db1.conta.contaapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
	
	List<Agencia> findByCidadeEstado(Estado estado);
	Agencia findByNumero(String numero); 
	
	@Query(nativeQuery = true, value = "select * from agencia where numero = :numero")
	Optional<Agencia> findByNumberOptional(@Param("numero") String numero);
	
	@Query(nativeQuery = true, value = "select * from agencia where estado = :estado")
	Optional<Agencia> findByEstadoOptional(@Param("estado") Estado estado);
	
	
}
