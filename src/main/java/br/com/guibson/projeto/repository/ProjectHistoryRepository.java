package br.com.guibson.projeto.repository;

import br.com.guibson.projeto.domain.ProjectHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Long> {

}
