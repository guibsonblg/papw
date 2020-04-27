package br.com.guibson.projeto.repository;

import br.com.guibson.projeto.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
