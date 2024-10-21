package com.br.back_end_projeto_pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.back_end_projeto_pi.models.Monitor;
import com.br.back_end_projeto_pi.repositorys.MonitorRepository;

@Service
public class MonitorService {
	@Autowired
	private MonitorRepository monitorRepository;
	public ResponseEntity<List<Monitor>> listarMonitors(){
		return ResponseEntity.ok(monitorRepository.findAll());
	}
	
	public ResponseEntity<Monitor>buscarMonitorPorId(long id){
		Monitor Monitor = monitorRepository.findById(id).orElse(null);
		if (Monitor == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(Monitor);
	}
	
	public ResponseEntity<Monitor>criarMonitor(Monitor monitor){
		return ResponseEntity.ok(monitorRepository.save(monitor));
	}
	
	public ResponseEntity<Monitor>atualizarMonitor(long id,Monitor monitor){
		if (monitorRepository.findById(id).orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}
		monitor.setId(id);
		return ResponseEntity.ok(monitorRepository.save(monitor));
	}
	
	public ResponseEntity<?>excluirMonitor(long id){
		if (monitorRepository.findById(id).orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}
		monitorRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
