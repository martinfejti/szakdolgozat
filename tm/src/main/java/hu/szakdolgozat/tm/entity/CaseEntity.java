package hu.szakdolgozat.tm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Case")
@Table(name = "test_case")
public class CaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "description")
    private String description;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentEntity component;
    
    @OneToMany(mappedBy = "testCase", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<StepEntity> steps;
    
    @OneToMany(mappedBy = "testCase", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CaseInstanceEntity> caseInstances;
    
    public CaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentEntity getComponent() {
        return component;
    }

    public void setComponent(ComponentEntity component) {
        this.component = component;
    }

    public List<StepEntity> getSteps() {
        return steps;
    }

    public void setSteps(List<StepEntity> steps) {
        this.steps = steps;
    }

    public List<CaseInstanceEntity> getCaseInstances() {
        return caseInstances;
    }

    public void setCaseInstances(List<CaseInstanceEntity> caseInstances) {
        this.caseInstances = caseInstances;
    }
}
