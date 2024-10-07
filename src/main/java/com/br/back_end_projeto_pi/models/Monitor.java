package com.br.back_end_projeto_pi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Monitor { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private long idTurma;
    public Monitor(String nome, long idTurma) {
    	this.nome = nome;
    	this.idTurma = idTurma;
    }
}
