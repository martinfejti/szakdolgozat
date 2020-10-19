package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import hu.szakdolgozat.tm.entity.StepInstanceStatusEnum;

public class CreateStepInstanceDto {

    @Size(max = 50)
    private String comment;
    
    @NotNull
    private StepInstanceStatusEnum status;
    
    @NotNull
    @Min(1)
    private Long stepId;
    
    @NotNull
    @Min(1)
    private Long caseInstanceId;
    
    public CreateStepInstanceDto() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public StepInstanceStatusEnum getStatus() {
        return status;
    }

    public void setStatus(StepInstanceStatusEnum status) {
        this.status = status;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public Long getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(Long caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }
}
