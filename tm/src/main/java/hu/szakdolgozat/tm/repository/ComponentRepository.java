package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.ComponentEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface ComponentRepository {

    public ComponentEntity getComponentEntityById(Long id) throws PersistenceException;
    
    public List<ComponentEntity> getComponentListByProjectId(Long id) throws PersistenceException;
    
}
