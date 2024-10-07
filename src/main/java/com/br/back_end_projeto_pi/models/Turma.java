package com.br.back_end_projeto_pi.models;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  Long id;
	  String nomeTurma;
	  String fotoTurma;
	  String fotoAtividades;
	  Long anoTurma;
	  @OneToMany(mappedBy = "idTurma")
	  List<Monitor> monitoresTurma;
  
  public Turma(String nomeTurma, String fotoTurma, Long anoTurma, List<Monitor> monitoresTurma) {
    this.nomeTurma = nomeTurma;
    this.fotoTurma = fotoTurma;
    this.anoTurma = anoTurma;
    this.monitoresTurma = monitoresTurma;
  }
  public Turma(String nomeTurma, String fotoTurma, String fotoAtividades, Long anoTurma, List<Monitor> monitoresTurma) {
    this.nomeTurma = nomeTurma;
    this.fotoTurma = fotoTurma;
    this.fotoAtividades = fotoAtividades;
    this.anoTurma = anoTurma;
    this.monitoresTurma = monitoresTurma;
  }

  
}
