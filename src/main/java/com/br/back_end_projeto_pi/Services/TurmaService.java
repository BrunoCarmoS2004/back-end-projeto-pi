package com.br.back_end_projeto_pi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.back_end_projeto_pi.Dtos.TurmaDTO;
import com.br.back_end_projeto_pi.Models.Turma;
import com.br.back_end_projeto_pi.Repositorys.TurmaRepository;

@Service
public class TurmaService {
  @Autowired
  private TurmaRepository turmaRepository;
  @Autowired

  public ResponseEntity<Object> listarTurmas(){
    return ResponseEntity.ok(turmaRepository.findAll());
  }

  public ResponseEntity<Object> criarTurma(TurmaDTO turmaDTO){
    Turma turma = Turma.builder()
    .nomeTurma(turmaDTO.nomeTurma())
    .anoTurma(turmaDTO.anoTurma())
    .fotoTurma(turmaDTO.fotoTurma())
    .fotoAtividades(turmaDTO.fotoAtividades())
    .monitoresTurma(turmaDTO.monitoresTurma())
    .build();
    turmaRepository.save(turma);
    return ResponseEntity.ok(turma);
  }

  public ResponseEntity<Object> atualizarTurma(Long id, TurmaDTO turmaDTO){
    if(!turmaRepository.existsById(id)){
      return ResponseEntity.badRequest().body("Turma não encontrada!");
    }
    Optional<Turma> turmaOptional = turmaRepository.findById(id);
    Turma turma = turmaOptional.get();
    turma.setIdTurma(id);
    turma.setNomeTurma(turmaDTO.nomeTurma());
    turma.setAnoTurma(turmaDTO.anoTurma());
    turma.setFotoAtividades(turmaDTO.fotoAtividades());
    turma.setFotoTurma(turmaDTO.fotoTurma());
    turma.setMonitoresTurma(turmaDTO.monitoresTurma());
    turmaRepository.save(turma);
    return ResponseEntity.ok(turma);
  }

  public ResponseEntity<Object> deletarTurma(Long id){
    if (!turmaRepository.existsById(id)){
      return ResponseEntity.badRequest().body("Turma não encontrada!");
    }
    turmaRepository.deleteById(id);
    return ResponseEntity.ok("Turma excluida com sucesso!");
  }
}
