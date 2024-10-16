package com.br.back_end_projeto_pi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteController {
  @GetMapping("teste")
  public String teste(){
    return "Deu certo";
  }
}
