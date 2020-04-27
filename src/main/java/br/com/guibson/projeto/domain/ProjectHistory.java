package br.com.guibson.projeto.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ProjectHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;

    @OneToOne
    private Person manager;

    @OneToOne
    private Project project;

    @OneToOne
    private DepartmentName departmentName;

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

//    public Person getManager() {
//        return manager;
//    }
//
//    public void setManager(Person manager) {
//        this.manager = manager;
//    }
}
