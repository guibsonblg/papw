package br.com.guibson.projeto.webRest;

import br.com.guibson.projeto.domain.Project;
import br.com.guibson.projeto.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRest {
    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project getProjectById(@PathVariable Long id) {
        return projectService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Project save(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Project update(@RequestBody @Valid Project project) {
        return projectService.save(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        projectService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
