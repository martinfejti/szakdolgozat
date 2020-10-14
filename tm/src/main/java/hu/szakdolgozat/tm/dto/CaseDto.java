package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CaseDto extends CreateCaseDto {

    @NotNull
    @Min(1)
    private Long id;
    
    public CaseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
