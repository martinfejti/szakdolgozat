package hu.szakdolgozat.tm.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CaseInstanceDto extends CreateCaseInstanceDto {

    @NotNull
    @Min(1)
    private Long id;
    
    @NotNull
    private Date openDate;
    
    private Date closeDate;
    
    private List<StepInstanceDto> stepInstances;
    
    public CaseInstanceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public List<StepInstanceDto> getStepInstances() {
        return stepInstances;
    }

    public void setStepInstances(List<StepInstanceDto> stepInstances) {
        this.stepInstances = stepInstances;
    }
}
