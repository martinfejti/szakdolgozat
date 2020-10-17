package hu.szakdolgozat.tm.entity;

import java.util.Date;
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

@Entity(name = "ComponentInstance")
@Table(name = "component_instance")
public class ComponentInstanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "open_date")
    private Date openDate;
    
    @Column(name = "close_date")
    private Date closeDate;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private ComponentEntity component;
    
    @OneToMany(mappedBy = "componentInstance", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CaseInstanceEntity> caseInstances;
    
    public ComponentInstanceEntity() {
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

    public ComponentEntity getComponent() {
        return component;
    }

    public void setComponent(ComponentEntity component) {
        this.component = component;
    }

    public List<CaseInstanceEntity> getCaseInstances() {
        return caseInstances;
    }

    public void setCaseInstances(List<CaseInstanceEntity> caseInstances) {
        this.caseInstances = caseInstances;
    }
}
