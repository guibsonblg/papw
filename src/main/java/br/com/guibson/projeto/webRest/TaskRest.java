package br.com.guibson.projeto.webRest;

import br.com.guibson.projeto.domain.DTO.TaskDTO;
import br.com.guibson.projeto.domain.Task;
import br.com.guibson.projeto.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class
TaskRest {
        @Autowired
        private TaskService taskService;

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public Task getTaskById(@PathVariable Long id) {
            return taskService.findById(id);
        }

    @GetMapping(value = {"/", "/search/{status}", "/search/{startDate}/{endDate}", "/search/{startDate}/{endDate}/{status}"})
    public List<TaskDTO> getTasks(@PathVariable(value = "startDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                  @PathVariable(value = "endDate",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                  @PathVariable(value = "status",required = false) Long status) {

        if (startDate == null && endDate == null && status == null) {

            return taskService.findAll();

        } else if (startDate != null && endDate != null && status != null) {

            return taskService.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatusIs(startDate, endDate, status);

        } else if (startDate != null && endDate != null && status == null) {

            return taskService.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);

        } else if (status != null && endDate == null && startDate == null){

            return taskService.findByStatus(status);

        } else {

            return taskService.findAll();
        }
    }
        @RequestMapping(method = RequestMethod.POST)
        public Task save(@RequestBody @Valid Task task) {
            return taskService.save(task);
        }

        @RequestMapping(method = RequestMethod.PUT)
        public Task update(@RequestBody @Valid Task task) {
            return taskService.save(task);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public ResponseEntity deleteById(@PathVariable Long id) {
            taskService.deleteById(id);
            return ResponseEntity.ok().build();
        }

    }

