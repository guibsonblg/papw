package br.com.guibson.projeto.service;

import br.com.guibson.projeto.domain.DTO.TaskDTO;
import br.com.guibson.projeto.domain.Task;
import br.com.guibson.projeto.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task findById(Long id){
        return taskRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<TaskDTO> findAll(){
        List<Task> tasks = taskRepository.findAll();
        return criarDTO(tasks);
    }

    public List<TaskDTO> findByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate){
        List<Task> tasks = taskRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
        return criarDTO(tasks);
    }

    public List<TaskDTO> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatusIs(LocalDate startDate, LocalDate endDate, Long status) {
        List<Task> tasks = taskRepository.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndStatusIs(startDate, endDate,status);
        return criarDTO(tasks);
    }

    public List<TaskDTO> findByStatus(Long status){
        List<Task> tasks = taskRepository.findByStatus(status);
        return criarDTO(tasks);
    }

    private List<TaskDTO> criarDTO(List<Task> tasks) {
        return tasks.stream().map(task -> new TaskDTO(task.getId(), task.getStartDate(), task.getEndDate(), task.getStatus(),task.getTitle(),task.getDescription(),task.getTaskPoints())).collect(Collectors.toList());
    }
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

}