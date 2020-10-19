package hu.szakdolgozat.tm.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import hu.szakdolgozat.tm.dto.UpdateStepDto;

public class UpdateCaseDto {

    @NotNull
    @Min(1)
    private Long id;
    
    @NotNull
    @Size(max = 30)
    private String name;
    
    @NotNull
    @Size(max = 30)
    private String description;
    
    @NotNull
    @Min(1)
    private Long componentId;
    
    private List<UpdateStepDto> steps;
    
    public UpdateCaseDto() {
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

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public List<UpdateStepDto> getSteps() {
        return steps;
    }

    public void setSteps(List<UpdateStepDto> steps) {
        this.steps = steps;
    }
}
