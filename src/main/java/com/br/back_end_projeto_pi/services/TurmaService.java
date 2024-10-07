package com.br.back_end_projeto_pi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.br.back_end_projeto_pi.models.Turma;
import com.br.back_end_projeto_pi.repositorys.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	private TurmaRepository turmaRepository;
	
	public ResponseEntity<List<Turma>> listarTurmas(){
		return ResponseEntity.ok(turmaRepository.findAll());
	}
	
	public ResponseEntity<Turma>buscarTurmaPorId(long id){
		Turma turma = turmaRepository.findById(id).orElse(null);
		if (turma == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(turma);
	}
	
	public ResponseEntity<List<Turma>>buscarTurmaPorIdMonitor(long id){
		List<Turma> turmas = turmaRepository.listarTurmasPorMonitor(id);
		if(turmas.isEmpty()) {
			return ResponseEntity.ok(new ArrayList<Turma>());
		}
		return ResponseEntity.ok(turmas);
	}
	
	public ResponseEntity<Turma>criarTurma(Turma turma){
		return ResponseEntity.ok(turmaRepository.save(turma));
	}
	
	public ResponseEntity<Turma>atualizarTurma(long id,Turma turma){
		if (turmaRepository.findById(id).orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(turmaRepository.save(turma));
	}
	
	public ResponseEntity<?>excluirTurma(long id){
		if (turmaRepository.findById(id).orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}
		turmaRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}
