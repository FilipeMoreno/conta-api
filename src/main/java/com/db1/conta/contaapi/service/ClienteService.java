package com.db1.conta.contaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db1.conta.contaapi.adapter.ClienteAdapter;
import com.db1.conta.contaapi.domain.dto.ClientePersistDTO;
import com.db1.conta.contaapi.domain.dto.ClienteResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.repository.ClienteRepository;

@Service
public class ClienteService {
		
	@Autowired
	private ClienteRepository clienteRepository;
	
	public ClienteResponseDTO save(ClientePersistDTO dto) {
		
		Cliente cliente = new Cliente(dto.getNome(), dto.getCpf());
		clienteRepository.save(cliente);
		return ClienteAdapter.entityToResponse(cliente);
	}
	
	public ClienteResponseDTO update(Long id, ClientePersistDTO dto) {
		
		Optional<Cliente> opCliente = clienteRepository.findById(id);
		if (opCliente.isPresent()) {
			Cliente cliente = opCliente.get();
			cliente.editarCliente(dto.getNome(), dto.getCpf());
			clienteRepository.save(cliente);
			return ClienteAdapter.entityToResponse(cliente);
		}		
		throw new RuntimeException("Cliente de ID" + id + " não encontrado.");
	}
	
	public void delete(Long id) {
		
		Optional<Cliente> opCliente = clienteRepository.findById(id);
		if (opCliente.isPresent()) {
			Cliente cliente = opCliente.get();
			clienteRepository.delete(cliente);
		} else {
			throw new RuntimeException("Cliente de ID " + id + " não encontrdo.");
		}
	}
	
	public ClienteResponseDTO findByName(String name) {
		
		Optional<Cliente> opCliente = clienteRepository.findByNomeOptional(name);
		if (opCliente.isPresent()) {
			Cliente cliente = opCliente.get();
			ClienteResponseDTO clienteResponse = ClienteAdapter.entityToResponse(cliente);
			return clienteResponse;
		}
		throw new RuntimeException("Cliente " + name + " não encontrado.");
	}
	
	public List<ClienteResponseDTO> findAll() {
		
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteResponseDTO> response = ClienteAdapter.entityToResponse(clientes);
		return response;
	}
	
	public ClienteResponseDTO findByID(Long id) {
		
		Optional<Cliente> opCliente = clienteRepository.findById(id);
		if (opCliente.isPresent()) {
			Cliente cliente = opCliente.get();
			ClienteResponseDTO clienteResponse = ClienteAdapter.entityToResponse(cliente);
			return clienteResponse;
		}
		throw new RuntimeException("Cliente ID " + id + " não encotrado.");
	}
	
	public ClienteResponseDTO findByCPF(String cpf) {
		
		Optional<Cliente> opCliente = clienteRepository.findByCFPOptional(cpf);
		if(opCliente.isPresent()) {
			Cliente cliente = opCliente.get();
			ClienteResponseDTO clienteResponse = ClienteAdapter.entityToResponse(cliente);
			return clienteResponse;
		}
		throw new RuntimeException("CPF " + cpf + " não encontrado.");
	}

}
