package com.db1.conta.contaapi.adapter;

import java.util.ArrayList;
import java.util.List;

import com.db1.conta.contaapi.domain.dto.ClienteResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cliente;

public class ClienteAdapter {
	
	public static ClienteResponseDTO entityToResponse(Cliente cliente) {
		
		ClienteResponseDTO responseDTO = new ClienteResponseDTO();
		responseDTO.setNome(cliente.getNome());
		responseDTO.setCpf(cliente.getCpf());
		return responseDTO;
	}
	
	public static List<ClienteResponseDTO> entityToResponse(List<Cliente> cliente) {
		List<ClienteResponseDTO> clienteResponse = new ArrayList<ClienteResponseDTO>();
		for (Cliente clientes : cliente) {
			clienteResponse.add(entityToResponse(clientes));
		}
		return clienteResponse;
	}
		
}
