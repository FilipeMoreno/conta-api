package com.db1.conta.contaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.db1.conta.contaapi.domain.dto.ClientePersistDTO;
import com.db1.conta.contaapi.domain.dto.ClienteResponseDTO;
import com.db1.conta.contaapi.service.ClienteService;;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/todos-clientes")
	public List<ClienteResponseDTO> todosClientes(){
		return clienteService.findAll();
	}
	
	@GetMapping
	public ClienteResponseDTO clientePorNome(@RequestParam("nome") String nome) {
		return clienteService.findByName(nome);
	}
	
	@GetMapping("{id}")
	public ClienteResponseDTO clientePorID(@PathVariable("id") Long id) {
		return clienteService.findByID(id);
	}
	
	@GetMapping("/cpf/{cpf}")
	public ClienteResponseDTO clientePorCPF(@PathVariable("cpf") String cpf) {
		return clienteService.findByCPF(cpf);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ClienteResponseDTO salvar(@RequestBody ClientePersistDTO body) {
		return clienteService.save(body);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deletar(@PathVariable("id") Long id) {
		clienteService.delete(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ClienteResponseDTO alterar(@PathVariable("id") Long id, @RequestBody ClientePersistDTO body) {
		return clienteService.update(id, body);
	}

}
