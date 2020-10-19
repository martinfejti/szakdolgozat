package hu.szakdolgozat.tm.dto;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CaseDto extends CreateCaseDto {

    @NotNull
    @Min(1)
    private Long id;
    
    private List<CaseInstanceDto> caseInstances;
    
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
}
