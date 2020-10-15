package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.ProjectEntity;

public interface ProjectRepository {

    public List<ProjectEntity> getAllProjects() throws Exception;
    
    public ProjectEntity getProjectById(Long id) throws Exception;
}
