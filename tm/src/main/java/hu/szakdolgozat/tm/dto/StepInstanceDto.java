package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StepInstanceDto extends CreateStepInstanceDto {
    
    @NotNull
    @Min(1)
    private Long id;
    
    public StepInstanceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
