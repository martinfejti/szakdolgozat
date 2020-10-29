package hu.szakdolgozat.tm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;
import hu.szakdolgozat.tm.exceptions.ControllerException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    public ProjectController() {
    }

    @PostMapping
    public ProjectDto createProject(@Valid @RequestBody CreateProjectDto createDto) throws ControllerException {
        try {
            return this.projectService.createProject(createDto);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @PutMapping
    public ProjectDto updateProject(@Valid @RequestBody ProjectDto projectDto) throws ControllerException {
        try {
            return this.projectService.updateProject(projectDto);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            this.projectService.deleteProjectById(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/getAllProjects")
    public List<ProjectDto> getAllProjects() throws ControllerException {
        try {
            return this.projectService.getAllProjects();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/{id}")
    public ProjectDto getProjectById(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.projectService.getProjectById(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
