package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.ComponentInstanceEntity;

public interface ComponentInstanceRepository {

    public List<ComponentInstanceEntity> getComponentInstanceListByComponentId(Long id) throws Exception;
    
    public List<ComponentInstanceEntity> getAllComponentInstances() throws Exception;
    
    public ComponentInstanceEntity getComponentInstanceEntityById(Long id) throws Exception;
    
}
