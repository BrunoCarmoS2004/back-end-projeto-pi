package com.br.back_end_projeto_pi.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.back_end_projeto_pi.models.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	@Query("SELECT t FROM Turma t JOIN Monitor m ON t.id = m.idTurma WHERE m.id = :idMonitor")
	List<Turma>listarTurmasPorMonitor(@Param("idMonitor") long id);
}
