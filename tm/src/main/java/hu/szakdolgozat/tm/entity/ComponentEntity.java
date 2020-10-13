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

@Entity(name = "Component")
@Table(name = "component")
public class ComponentEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @NotNull
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "description")
    private String description;
    
    @NotNull
    @Column(name = "create_date")
    private Date createDate;
    
    @NotNull
    @Column(name = "author")
    private String author;
    
    @NotNull
    @Column(name = "version")
    private String version;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;
    
    @OneToMany(mappedBy="component", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CaseEntity> caseEntities;
    
    @OneToMany(mappedBy="component", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ComponentInstanceEntity> componentInstances;
    
    public ComponentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public List<CaseEntity> getCaseEntities() {
        return caseEntities;
    }

    public void setCaseEntities(List<CaseEntity> caseEntities) {
        this.caseEntities = caseEntities;
    }

    public List<ComponentInstanceEntity> getComponentInstances() {
        return componentInstances;
    }

    public void setComponentInstances(List<ComponentInstanceEntity> componentInstances) {
        this.componentInstances = componentInstances;
    }
}
