package hu.szakdolgozat.tm.dto;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateStepInstanceDto {

    @NotNull
    private Date testDate;
    
    @Size(max = 50)
    private String comment;
    
    @NotNull
    @Min(1)
    private int statusId;
    
    @NotNull
    @Min(1)
    private Long stepId;
    
    @NotNull
    @Min(1)
    private Long caseInstanceId;
    
    public CreateStepInstanceDto() {
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Long getStepId() {
        return stepId;
    }

    public void setStepId(Long stepId) {
        this.stepId = stepId;
    }

    public Long getCaseInstanceId() {
        return caseInstanceId;
    }

    public void setCaseInstanceId(Long caseInstanceId) {
        this.caseInstanceId = caseInstanceId;
    }
}
