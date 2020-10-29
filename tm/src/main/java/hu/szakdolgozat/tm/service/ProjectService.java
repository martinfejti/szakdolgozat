package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface ProjectService {

    public ProjectDto createProject(CreateProjectDto createDto) throws ServiceException;
    
    public ProjectDto updateProject(ProjectDto projectDto) throws ServiceException;
    
    public void deleteProjectById(Long id) throws ServiceException;
    
    public List<ProjectDto> getAllProjects() throws ServiceException;
    
    public ProjectDto getProjectById(Long id) throws ServiceException;
    
}
