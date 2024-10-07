package com.br.back_end_projeto_pi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aviso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String tituloAvisoString;
	private String conteudoAviso;
	private LocalDateTime dataCriacaoAviso;
	private LocalDateTime dataEnvioAviso;
	private String criadorAviso;
}
