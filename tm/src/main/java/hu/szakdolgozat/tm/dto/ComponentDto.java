package hu.szakdolgozat.tm.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ComponentDto extends CreateComponentDto {

    @NotNull
    @Min(1)
    private Long id;
    
    @NotNull
    private Date createDate;
    
    private List<CaseDto> testCases;
    
    private List<ComponentInstanceDto> componentInstances;
    
    public ComponentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<CaseDto> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<CaseDto> testCases) {
        this.testCases = testCases;
    }

    public List<ComponentInstanceDto> getComponentInstances() {
        return componentInstances;
    }

    public void setComponentInstances(List<ComponentInstanceDto> componentInstances) {
        this.componentInstances = componentInstances;
    }
}
