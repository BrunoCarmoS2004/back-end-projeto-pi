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

import com.br.back_end_projeto_pi.models.Turma;
import com.br.back_end_projeto_pi.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	@GetMapping
	public ResponseEntity<List<Turma>>listarTurmas(){
		return turmaService.listarTurmas();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Turma>buscarTurmaPorId(@PathVariable long id){
		return turmaService.buscarTurmaPorId(id);
	}
	@GetMapping("/monitor/{id}")
	public ResponseEntity<List<Turma>>buscarTurmaPorMonitor(@PathVariable long id){
		return turmaService.buscarTurmaPorIdMonitor(id);
	}
	
	@PostMapping("/criar")
	public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
		return turmaService.criarTurma(turma);
	}
	
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Turma> atualizarTurma(@PathVariable long id, @RequestBody Turma turma) {
		return turmaService.atualizarTurma(id, turma);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>excluirTurma(long id){
		return turmaService.excluirTurma(id);
	}
}
