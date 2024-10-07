package com.br.back_end_projeto_pi.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.back_end_projeto_pi.models.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long>{

}
