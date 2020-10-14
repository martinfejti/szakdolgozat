package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateComponentInstanceDto {
    
    @NotNull
    @Min(1)
    private Long componentId;
    
    public CreateComponentInstanceDto() {
    }

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }
}
