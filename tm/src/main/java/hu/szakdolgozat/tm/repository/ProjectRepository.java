package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.ProjectEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface ProjectRepository {

    public List<ProjectEntity> getAllProjects() throws PersistenceException;
    
    public ProjectEntity getProjectById(Long id) throws PersistenceException;
}
