package com.br.back_end_projeto_pi.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turma {
  Long idTurma;
  String nomeTurma;
  String fotoTurma;
  String fotoAtividades;
  Long anoTurma;
  List<String> monitoresTurma;
  
  public Turma(String nomeTurma, String fotoTurma, Long anoTurma, List<String> monitoresTurma) {
    this.nomeTurma = nomeTurma;
    this.fotoTurma = fotoTurma;
    this.anoTurma = anoTurma;
    this.monitoresTurma = monitoresTurma;
  }
  public Turma(String nomeTurma, String fotoTurma, String fotoAtividades, Long anoTurma, List<String> monitoresTurma) {
    this.nomeTurma = nomeTurma;
    this.fotoTurma = fotoTurma;
    this.fotoAtividades = fotoAtividades;
    this.anoTurma = anoTurma;
    this.monitoresTurma = monitoresTurma;
  }

  
}
