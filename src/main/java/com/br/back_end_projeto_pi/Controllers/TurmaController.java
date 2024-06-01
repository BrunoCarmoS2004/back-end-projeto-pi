package com.br.back_end_projeto_pi.Controllers;

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

import com.br.back_end_projeto_pi.Dtos.TurmaDTO;
import com.br.back_end_projeto_pi.Services.TurmaService;

@RestController
@RequestMapping("turmas")
public class TurmaController {
  @Autowired
  private TurmaService turmaService;

  @GetMapping
  public ResponseEntity<Object> listarTurmas(){
    return turmaService.listarTurmas();
  }

  @PostMapping("/criar")
  public ResponseEntity<Object> criarTurmas(@RequestBody TurmaDTO turmaDTO){
    return turmaService.criarTurma(turmaDTO);
  }

  @PutMapping("atualizar/{id}")
  public ResponseEntity<Object> atualizarTurmas(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO){
    return turmaService.atualizarTurma(id, turmaDTO);
  }

  @DeleteMapping("deletar/{id}")
  public ResponseEntity<Object> deletarTurmas(@PathVariable Long id){
    return turmaService.deletarTurma(id);
  }
}
