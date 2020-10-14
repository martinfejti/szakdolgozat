package hu.szakdolgozat.tm.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class CreateProjectDto {

    @NotNull
    @Size(max = 30)
    private String name;
    
    @NotNull
    @Size(max = 50)
    private String shortDescription;
    
    @Size(max = 100)
    private String longDescription;
    
    public CreateProjectDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
