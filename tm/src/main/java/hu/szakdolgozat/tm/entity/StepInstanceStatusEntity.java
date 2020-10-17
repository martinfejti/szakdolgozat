package hu.szakdolgozat.tm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "StepInstanceStatus")
@Table(name = "step_instance_status")
public class StepInstanceStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StepInstanceStatusEnum stepInstanceStatus;
    
    public StepInstanceStatusEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StepInstanceStatusEnum getStepInstanceStatus() {
        return stepInstanceStatus;
    }

    public void setStepInstanceStatus(StepInstanceStatusEnum stepInstanceStatus) {
        this.stepInstanceStatus = stepInstanceStatus;
    }
}
