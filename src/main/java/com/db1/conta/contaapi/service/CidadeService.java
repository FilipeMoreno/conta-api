package com.db1.conta.contaapi.service;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.CidadeAdapter;
import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.Historico;
import com.db1.conta.contaapi.domain.entity.HistoricoTipo;
import com.db1.conta.contaapi.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeResponseDTO save(CidadePersistDTO dto) {
		
		Cidade cidade = new Cidade(dto.getNome(), dto.getEstado());
		cidadeRepository.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
	}
	
	public CidadeResponseDTO update(Long cidadeId, CidadePersistDTO dto) {
//		Cidade cidade = cidadeRepository.findById(cidadeId)
//				.orElseThrow(() -> new RuntimeException("Cidade de ID " + cidadeId + " não encontrada"));
//		
//		cidade.alterar(dto.getNome(), dto.getEstado());
//		cidadeRepository.save(cidade);
//		return CidadeAdapter.entityToResponse(cidade);
		
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if (opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidade.alterar(dto.getNome(), dto.getEstado());
			cidadeRepository.save(cidade);
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade de ID " + cidadeId + " não encontrada");	
	}

	
}
