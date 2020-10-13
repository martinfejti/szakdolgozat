package hu.szakdolgozat.tm.entity;

import java.util.Date;
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

@Entity(name = "CaseInstance")
@Table(name = "case_instance")
public class CaseInstanceEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "open_date")
    private Date openDate;
    
    @NotNull
    @Column(name = "close_date")
    private Date closeDate;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private CaseEntity testCase;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "component_instance_id", nullable = false)
    private ComponentInstanceEntity componentInstance;
    
    @OneToMany(mappedBy = "caseInstance", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<StepInstanceEntity> stepInstances;
    
    public CaseInstanceEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public CaseEntity getTestCase() {
        return testCase;
    }

    public void setTestCase(CaseEntity testCase) {
        this.testCase = testCase;
    }

    public ComponentInstanceEntity getComponentInstance() {
        return componentInstance;
    }

    public void setComponentInstance(ComponentInstanceEntity componentInstance) {
        this.componentInstance = componentInstance;
    }

    public List<StepInstanceEntity> getStepInstances() {
        return stepInstances;
    }

    public void setStepInstances(List<StepInstanceEntity> stepInstances) {
        this.stepInstances = stepInstances;
    }
}
