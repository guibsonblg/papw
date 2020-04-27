package br.com.guibson.projeto.webRest;

import br.com.guibson.projeto.domain.Person;
import br.com.guibson.projeto.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonRest {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getPersons() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person save(@RequestBody @Valid Person person) {
        return personService.save(person);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Person update(@RequestBody @Valid Person person) {
        return personService.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}