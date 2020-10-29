package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.ComponentInstanceEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface ComponentInstanceRepository {

    public List<ComponentInstanceEntity> getComponentInstanceListByComponentId(Long id) throws PersistenceException;
    
    public List<ComponentInstanceEntity> getAllComponentInstances() throws PersistenceException;
    
    public ComponentInstanceEntity getComponentInstanceEntityById(Long id) throws PersistenceException;
    
}
