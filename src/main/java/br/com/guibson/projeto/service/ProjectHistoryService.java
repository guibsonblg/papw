package br.com.guibson.projeto.service;

import br.com.guibson.projeto.domain.ProjectHistory;
import br.com.guibson.projeto.repository.ProjectHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjectHistoryService {
    @Autowired
    private ProjectHistoryRepository projectHistoryRepository;

    public ProjectHistory save(ProjectHistory projectHistory){
        return projectHistoryRepository.save(projectHistory);
    }

    public ProjectHistory findById(Long id){
        return projectHistoryRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<ProjectHistory> findAll(){
        return projectHistoryRepository.findAll();
    }


    public void deleteById(Long id) {
        projectHistoryRepository.deleteById(id);
    }
}

