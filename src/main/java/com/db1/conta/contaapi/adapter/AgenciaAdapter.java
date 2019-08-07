package com.db1.conta.contaapi.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.db1.conta.contaapi.domain.dto.AgenciaResponseDTO;
import com.db1.conta.contaapi.domain.entity.Agencia;

public class AgenciaAdapter {
	
	public static AgenciaResponseDTO entityToResponse(Agencia agencia) {
		
		AgenciaResponseDTO responseDTO = new AgenciaResponseDTO();
		responseDTO.setId(agencia.getId());
		responseDTO.setNumero(agencia.getNumero());
		responseDTO.setDigito(agencia.getDigito());
		responseDTO.setCidade(agencia.getCidade());
		return responseDTO;
	}
	
	public static AgenciaResponseDTO entityToResponse(Optional<Agencia> agencia) {
		
		AgenciaResponseDTO responseDTO = new AgenciaResponseDTO();
		responseDTO.setNumero(agencia.get().getNumero());
		responseDTO.setDigito(agencia.get().getDigito());
		responseDTO.setCidade(agencia.get().getCidade());
		return responseDTO;
	}
	
	public static List<AgenciaResponseDTO> entityToResponse(List<Agencia> agencias){
		List<AgenciaResponseDTO> agenciasResponse = new ArrayList<AgenciaResponseDTO>();
		for (Agencia agencia : agencias) {
			agenciasResponse.add(entityToResponse(agencia));
		}
		return agenciasResponse;
	}

}
