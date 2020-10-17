package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateComponentDto {

    @NotNull
    @Min(1)
    private Long id;
    
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
    
    public UpdateComponentDto() {
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
}
