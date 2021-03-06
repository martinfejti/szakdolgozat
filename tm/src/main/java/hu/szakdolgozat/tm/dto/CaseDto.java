package hu.szakdolgozat.tm.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CaseDto {

    @NotNull
    @Min(1)
    private Long id;
    
    private List<CaseInstanceDto> caseInstances;
    
    @NotNull
    @Size(max = 30)
    private String name;
    
    @NotNull
    @Size(max = 30)
    private String description;
    
    @NotNull
    @Min(1)
    private Long componentId;
    
    @Size(min = 1)
    private List<StepDto> steps;
    
    public CaseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CaseInstanceDto> getCaseInstances() {
        return caseInstances;
    }

    public void setCaseInstances(List<CaseInstanceDto> caseInstances) {
        this.caseInstances = caseInstances;
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

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public List<StepDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDto> steps) {
        this.steps = steps;
    }
}
