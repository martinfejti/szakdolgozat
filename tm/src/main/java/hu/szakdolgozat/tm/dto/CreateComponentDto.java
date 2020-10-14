package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateComponentDto {

    @NotNull
    @Size(max = 30)
    private String name;
    
    @NotNull
    @Size(max = 50)
    private String description;
    
    @NotNull
    @Size(max = 25)
    private String author;
    
    @NotNull
    @Size(max = 25)
    private String version;
    
    @NotNull
    @Min(1)
    private Long projectId;
    
    public CreateComponentDto() {
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
