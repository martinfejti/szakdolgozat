package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateStepDto {

    private Long id;
    
    @NotNull
    @Min(1)
    private Long caseId;
    
    @NotNull
    @Min(1)
    private int orderNumber;
    
    @NotNull
    @Size(max = 100)
    private String description;
    
    @NotNull
    @Size(max = 100)
    private String expectedResult;
    
    @Size(max = 50)
    private String comment;
    
    public UpdateStepDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
