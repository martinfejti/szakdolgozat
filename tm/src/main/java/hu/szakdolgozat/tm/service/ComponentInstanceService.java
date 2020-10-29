package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.ComponentInstanceDto;
import hu.szakdolgozat.tm.dto.CreateComponentInstanceDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface ComponentInstanceService {

    public ComponentInstanceDto createComponentInstance(CreateComponentInstanceDto createDto) throws ServiceException;
    
    public ComponentInstanceDto closeComponentInstance(Long id) throws ServiceException;
    
    public List<ComponentInstanceDto> getAllComponentInstances() throws ServiceException;
    
    public List<ComponentInstanceDto> getAllComponentInstancesByComponentId(Long id) throws ServiceException;
    
}
