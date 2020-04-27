package br.com.guibson.projeto.webRest;

import br.com.guibson.projeto.domain.DepartmentName;
import br.com.guibson.projeto.service.DepartmentNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/departmentNames")
public class DepartmentNameRest {
    @Autowired
    private DepartmentNameService departmentNameService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DepartmentName getDepartmentNameById(@PathVariable Long id) {
        return departmentNameService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<DepartmentName> getDepartmentNames() {
        return departmentNameService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public DepartmentName save(@RequestBody @Valid DepartmentName departmentName) {
        return departmentNameService.save(departmentName);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public DepartmentName update(@RequestBody @Valid DepartmentName departmentName) {
        return departmentNameService.save(departmentName);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteById(@PathVariable Long id) {
        departmentNameService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}