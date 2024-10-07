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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.back_end_projeto_pi.models.Monitor;
import com.br.back_end_projeto_pi.services.MonitorService;

@RestController
@RequestMapping("/monitores")
public class MonitorController {
	@Autowired
	private MonitorService monitorService;
	
	@GetMapping
	public ResponseEntity<List<Monitor>>listarMonitors(){
		return monitorService.listarMonitors();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Monitor>buscarMonitorPorId(@PathVariable long id){
		return monitorService.buscarMonitorPorId(id);
	}

	@PostMapping("/criar")
	public ResponseEntity<Monitor> criarMonitor(@RequestBody Monitor Monitor) {
		return monitorService.criarMonitor(Monitor);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Monitor> atualizarMonitor(@PathVariable long id, @RequestBody Monitor Monitor) {
		return monitorService.atualizarMonitor(id, Monitor);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>excluirMonitor(long id){
		return monitorService.excluirMonitor(id);
	}
}
