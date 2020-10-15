package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.ComponentEntity;

public interface ComponentRepository {

    public ComponentEntity getComponentEntityById(Long id) throws Exception;
    
    public List<ComponentEntity> getComponentListByProjectId(Long id) throws Exception;
    
}
