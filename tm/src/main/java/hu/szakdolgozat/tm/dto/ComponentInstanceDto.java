package hu.szakdolgozat.tm.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ComponentInstanceDto extends CreateComponentInstanceDto {

    @NotNull
    @Min(1)
    private Long id;
    
    @NotNull
    private Date openDate;
    
    private Date closeDate;
    
    private List<CaseInstanceDto> caseInstances;
    
    public ComponentInstanceDto() {
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

    public List<CaseInstanceDto> getCaseInstances() {
        return caseInstances;
    }

    public void setCaseInstances(List<CaseInstanceDto> caseInstances) {
        this.caseInstances = caseInstances;
    }
}
