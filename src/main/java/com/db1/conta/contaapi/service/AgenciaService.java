package com.db1.conta.contaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.AgenciaAdapter;
import com.db1.conta.contaapi.domain.dto.AgenciaPersistDTO;
import com.db1.conta.contaapi.domain.dto.AgenciaResponseDTO;
import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.repository.AgenciaRepository;

@Service
public class AgenciaService {
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	public AgenciaResponseDTO save(AgenciaPersistDTO dto) {
		Agencia agencia = new Agencia(dto.getNumero(), dto.getDigito(), dto.getCidade());
		agenciaRepository.save(agencia);
		return AgenciaAdapter.entityToResponse(agencia);
	}
	
	public AgenciaResponseDTO update(Long id, AgenciaPersistDTO dto) {
		
		Optional<Agencia> opAgencia = agenciaRepository.findById(id);
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			agencia.alterarAgencia(dto.getNumero(), dto.getDigito(), dto.getCidade());
			agenciaRepository.save(agencia);
			return AgenciaAdapter.entityToResponse(agencia);
		}		
		throw new RuntimeException("Agencia de ID" + id + " não encontrada");
	}
	
	public List<AgenciaResponseDTO> findAll() {
		List<Agencia> agencias = agenciaRepository.findAll();
		List<AgenciaResponseDTO> response = AgenciaAdapter.entityToResponse(agencias);
		return response;
	}
	
	public AgenciaResponseDTO findByNumber(String number) {
		
		Optional<Agencia> opAgencia = agenciaRepository.findByNumberOptional(number);
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			AgenciaResponseDTO agenciaResponse = AgenciaAdapter.entityToResponse(agencia);
			return agenciaResponse;
		}
		throw new RuntimeException("Agência " + number + " não encontrada.");
	}
	
	public AgenciaResponseDTO findByID(Long id) {
		
		Optional<Agencia> opAgencia = agenciaRepository.findById(id);
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			AgenciaResponseDTO agenciaResponse = AgenciaAdapter.entityToResponse(agencia);
			return agenciaResponse;
		}
		throw new RuntimeException("Agência de ID " + id + " não encontrada.");
	}
	
	public List<AgenciaResponseDTO> findAllEstado(Estado estado) {
		
		Optional<Agencia> agencia = agenciaRepository.findByEstadoOptional(estado);
		List<AgenciaResponseDTO> response = (List<AgenciaResponseDTO>) AgenciaAdapter.entityToResponse(agencia);
		if (agencia.isPresent()) {
			return response;
		}
		throw new RuntimeException("Estado " + estado + " não encontrado.");
	}
	
	public void delete(Long id) {
		
		Optional<Agencia> opAgencia = agenciaRepository.findById(id);
		
		if (opAgencia.isPresent()) {
			Agencia agencia = opAgencia.get();
			agenciaRepository.delete(agencia);
		} else {
			throw new RuntimeException("Agência de ID " + id + " não encontrada");	
		}
	}
}
