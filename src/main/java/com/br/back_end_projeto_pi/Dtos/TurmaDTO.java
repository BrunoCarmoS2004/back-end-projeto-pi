package com.br.back_end_projeto_pi.Dtos;

import java.util.List;

public record TurmaDTO(String nomeTurma, String fotoTurma, String fotoAtividades, Long anoTurma, List<String> monitoresTurma) {
}
