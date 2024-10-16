package com.br.back_end_projeto_pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.back_end_projeto_pi.models.Aviso;
import com.br.back_end_projeto_pi.repositorys.AvisoRepository;

@Service
public class AvisoService {
	@Autowired
	private AvisoRepository avisoRepository;
	
	public ResponseEntity<List<Aviso>> listarAvisos(){
		return ResponseEntity.ok(avisoRepository.findAll());
	}
	
	public ResponseEntity<Aviso>buscarAvisoPorId(long id){
		Aviso Aviso = avisoRepository.findById(id).orElse(null);
		if (Aviso == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(Aviso);
	}
	
	public ResponseEntity<Aviso>criarAviso(Aviso aviso){
		avisoRepository.save(aviso);
		return ResponseEntity.ok(aviso);
	}
	
	public ResponseEntity<Aviso>atualizarAviso(long id,Aviso Aviso){
		if (avisoRepository.findById(id).orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(avisoRepository.save(Aviso));
	}
	
	public ResponseEntity<?>excluirAviso(long id){
		if (avisoRepository.findById(id).orElse(null) == null) {
			return ResponseEntity.badRequest().build();
		}
		avisoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
