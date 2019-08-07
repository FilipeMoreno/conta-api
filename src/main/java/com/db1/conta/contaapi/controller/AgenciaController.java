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

import com.db1.conta.contaapi.domain.dto.AgenciaPersistDTO;
import com.db1.conta.contaapi.domain.dto.AgenciaResponseDTO;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.service.AgenciaService;

@RestController
@RequestMapping("/api/agencia")
public class AgenciaController {
	
	@Autowired
	private AgenciaService agenciaService;
	
	@GetMapping("/todas-agencias")
	public List<AgenciaResponseDTO> todasAgencia() {
		return agenciaService.findAll();
	}
	
	@GetMapping
	public AgenciaResponseDTO agenciaPorNumero(@RequestParam("numero") String numero) {
		return agenciaService.findByNumber(numero);
	}
	
	@GetMapping("{id}")
	public AgenciaResponseDTO agenciaPorID(@PathVariable("id") Long id) {
		return agenciaService.findByID(id);
	}
	
	@GetMapping("/estado")
	public List<AgenciaResponseDTO> agenciaPorEstado(@RequestParam("uf") Estado estado) {
		return agenciaService.findAllEstado(estado);
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgenciaResponseDTO salvar(@RequestBody AgenciaPersistDTO body) {
		return agenciaService.save(body);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deletar(@PathVariable("id") Long id) {
		agenciaService.delete(id);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public AgenciaResponseDTO alterar(@RequestBody AgenciaPersistDTO body, @PathVariable("id") Long id) {
		return agenciaService.update(id, body);
	}
}
