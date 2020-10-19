package hu.szakdolgozat.tm.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StepDto extends CreateStepDto {

    @NotNull
    @Min(1)
    private Long id;
    
    @NotNull
    @Min(1)
    private Long caseId;
    
    private List<StepInstanceDto> stepInstances;
    
    public StepDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public List<StepInstanceDto> getStepInstances() {
        return stepInstances;
    }

    public void setStepInstances(List<StepInstanceDto> stepInstances) {
        this.stepInstances = stepInstances;
    }
}
