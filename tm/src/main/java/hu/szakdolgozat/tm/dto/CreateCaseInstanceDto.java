package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateCaseInstanceDto {

    @NotNull
    @Min(1)
    private Long caseId;
    
    @NotNull
    @Min(1)
    private Long componentInstanceId;
    
    public CreateCaseInstanceDto() {
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public Long getComponentInstanceId() {
        return componentInstanceId;
    }

    public void setComponentInstanceId(Long componentInstanceId) {
        this.componentInstanceId = componentInstanceId;
    }
}
