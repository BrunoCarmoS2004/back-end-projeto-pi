package com.br.back_end_projeto_pi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuarios {
  Long idAdmin;
  String email;
  String password;
  String nomeAdmin;
}
