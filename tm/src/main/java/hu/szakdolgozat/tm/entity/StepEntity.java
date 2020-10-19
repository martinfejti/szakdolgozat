package hu.szakdolgozat.tm.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Step")
@Table(name = "step")
public class StepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "order_number")
    private int orderNumber;
    
    @NotNull
    @Column(name = "description")
    private String description;
    
    @NotNull
    @Column(name = "expected_result")
    private String expectedResult;
    
    @Column(name = "comment")
    private String comment;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private CaseEntity testCase;
    
    @OneToMany(mappedBy = "step", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<StepInstanceEntity> stepInstances;
    
    public StepEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CaseEntity getTestCase() {
        return testCase;
    }

    public void setTestCase(CaseEntity testCase) {
        this.testCase = testCase;
    }

    /*
    public List<StepInstanceEntity> getStepInstances() {
        return stepInstances;
    }

    public void setStepInstances(List<StepInstanceEntity> stepInstances) {
        this.stepInstances = stepInstances;
    }
    
    */
}
