package com.br.back_end_projeto_pi.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Turma {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long idTurma;
  @NotBlank(message = "O nome da turma não pode estar em branco")
  String nomeTurma;
  String fotoTurma;
  String fotoAtividades;
  Long anoTurma;
  List<String> monitoresTurma;

  public Turma(String nomeTurma, String fotoTurma, String fotoAtividades, Long anoTurma, List<String> monitoresTurma) {
    this.nomeTurma = nomeTurma;
    this.fotoTurma = fotoTurma;
    this.fotoAtividades = fotoAtividades;
    this.anoTurma = anoTurma;
    this.monitoresTurma = monitoresTurma;
  }
}
