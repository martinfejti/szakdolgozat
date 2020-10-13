package hu.szakdolgozat.tm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "StepInstance")
@Table(name = "step_instance")
public class StepInstanceEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "test_date")
    private Date testDate;
    
    @Column(name = "comment")
    private String comment;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "step_id", nullable = false)
    private StepEntity step;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "case_instance_id", nullable = false)
    private CaseInstanceEntity caseInstance;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "step_instance_status_id", nullable = false)
    private StepInstanceStatusEntity stepInstanceStatus;
    
    public StepInstanceEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StepEntity getStep() {
        return step;
    }

    public void setStep(StepEntity step) {
        this.step = step;
    }

    public CaseInstanceEntity getCaseInstance() {
        return caseInstance;
    }

    public void setCaseInstance(CaseInstanceEntity caseInstance) {
        this.caseInstance = caseInstance;
    }

    public StepInstanceStatusEntity getStepInstanceStatus() {
        return stepInstanceStatus;
    }

    public void setStepInstanceStatus(StepInstanceStatusEntity stepInstanceStatus) {
        this.stepInstanceStatus = stepInstanceStatus;
    }
}
