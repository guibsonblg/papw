package br.com.guibson.projeto.repository;

import br.com.guibson.projetodomain.DepartmentName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentNameRepository extends JpaRepository<DepartmentName, Long> {

}
