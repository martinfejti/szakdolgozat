package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class StepDto extends CreateStepDto {

    @NotNull
    @Min(1)
    private Long id;
    
    public StepDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
