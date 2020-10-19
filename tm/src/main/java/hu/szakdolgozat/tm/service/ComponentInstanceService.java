package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.ComponentInstanceDto;
import hu.szakdolgozat.tm.dto.CreateComponentInstanceDto;

public interface ComponentInstanceService {

    public ComponentInstanceDto createComponentInstance(CreateComponentInstanceDto createDto) throws Exception;
    
    public ComponentInstanceDto closeComponentInstance(Long id) throws Exception;
    
    public List<ComponentInstanceDto> getAllComponentInstances() throws Exception;
    
    public List<ComponentInstanceDto> getAllComponentInstancesByComponentId(Long id) throws Exception;
    
}
