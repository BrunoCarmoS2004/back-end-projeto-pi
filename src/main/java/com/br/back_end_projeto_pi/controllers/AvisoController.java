package com.br.back_end_projeto_pi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.back_end_projeto_pi.models.Aviso;
import com.br.back_end_projeto_pi.models.Monitor;
import com.br.back_end_projeto_pi.services.AvisoService;

@RestController
@RequestMapping("/avisos")
public class AvisoController {
	@Autowired
	private AvisoService avisoService;
	
	@GetMapping
	public ResponseEntity<List<Aviso>>listarMonitors(@RequestHeader("Token") String token){
		if (!"UniFil2944".equals(token)) {
			return ResponseEntity.badRequest().build();
		}
		return avisoService.listarAvisos();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Aviso>buscarMonitorPorId(@PathVariable long id, @RequestHeader("Token")String token){
		if (!"UniFil2944".equals(token)) {
			return ResponseEntity.badRequest().build();
		}
		return avisoService.buscarAvisoPorId(id);
	}

	@PostMapping("/criar")
	public ResponseEntity<Aviso> criarMonitor(@RequestBody Aviso aviso, @RequestHeader("Token")String token) {
		if (!"UniFil2944".equals(token)) {
			return ResponseEntity.badRequest().build();
		}
		return avisoService.criarAviso(aviso);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Aviso> atualizarMonitor(@PathVariable long id, @RequestBody Aviso aviso, @RequestHeader("Token")String token) {
		if (!"UniFil2944".equals(token)) {
			return ResponseEntity.badRequest().build();
		}
		return avisoService.atualizarAviso(id, aviso);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>excluirMonitor(long id, @RequestHeader("Token")String token){
		if (!"UniFil2944".equals(token)) {
			return ResponseEntity.badRequest().build();
		}
		return avisoService.excluirAviso(id);
	}
}
