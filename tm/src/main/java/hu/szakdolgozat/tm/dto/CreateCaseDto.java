package hu.szakdolgozat.tm.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCaseDto {

    @NotNull
    @Size(max = 30)
    private String name;
    
    @NotNull
    @Size(max = 30)
    private String description;
    
    @NotNull
    @Min(1)
    private Long componentId;
    
    private List<CreateStepDto> steps;
    
    public CreateCaseDto() {
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

    public List<CreateStepDto> getSteps() {
        return steps;
    }

    public void setSteps(List<CreateStepDto> steps) {
        this.steps = steps;
    }
}
