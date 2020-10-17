package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.ComponentDto;
import hu.szakdolgozat.tm.dto.CreateComponentDto;
import hu.szakdolgozat.tm.dto.UpdateComponentDto;

public interface ComponentService {

    public ComponentDto createComponent(CreateComponentDto createDto) throws Exception;
    
    public ComponentDto updateComponent(UpdateComponentDto updateComponentDto) throws Exception;
    
    public void deleteComponent(Long id) throws Exception;
    
    public List<ComponentDto> getComponentsByProjectId(Long id) throws Exception;
    
}
