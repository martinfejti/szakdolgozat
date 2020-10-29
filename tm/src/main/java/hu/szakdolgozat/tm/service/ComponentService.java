package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.ComponentDto;
import hu.szakdolgozat.tm.dto.CreateComponentDto;
import hu.szakdolgozat.tm.dto.UpdateComponentDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface ComponentService {

    public ComponentDto createComponent(CreateComponentDto createDto) throws ServiceException;
    
    public ComponentDto updateComponent(UpdateComponentDto updateComponentDto) throws ServiceException;
    
    public void deleteComponent(Long id) throws ServiceException;
    
    public List<ComponentDto> getComponentsByProjectId(Long id) throws ServiceException;
    
}
