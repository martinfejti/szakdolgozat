package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;

public interface ProjectService {

    public ProjectDto createProject(CreateProjectDto createDto) throws Exception;
    
    public ProjectDto updateProject(ProjectDto projectDto) throws Exception;
    
    public void deleteProjectById(Long id) throws Exception;
    
    public List<ProjectDto> getAllProjects() throws Exception;
    
    public ProjectDto getProjectById(Long id) throws Exception;
    
}
