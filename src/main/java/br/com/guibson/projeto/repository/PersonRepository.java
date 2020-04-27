package br.com.guibson.projeto.repository;

import br.com.guibson.projeto.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
