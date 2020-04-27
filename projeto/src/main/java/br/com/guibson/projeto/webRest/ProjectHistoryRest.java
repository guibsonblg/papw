package br.com.guibson.projeto.webRest;

import br.com.guibson.projeto.domain.ProjectHistory;
import br.com.guibson.projeto.service.ProjectHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/projectHistories")
public class ProjectHistoryRest {
    @Autowired
    private ProjectHistoryService projectHistoryService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProjectHistory getProjectHistoryById(@PathVariable Long id) {
        return projectHistoryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectHistory> getProjectHistorys() {
        return projectHistoryService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProjectHistory save(@RequestBody @Valid ProjectHistory projectHistory) {
        return projectHistoryService.save(projectHistory);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ProjectHistory update(@RequestBody @Valid ProjectHistory projectHistory) {
        return projectHistoryService.save(projectHistory);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        projectHistoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
