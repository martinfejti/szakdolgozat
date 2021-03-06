package hu.szakdolgozat.tm.service.impl;

import java.util.Date;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.ComponentDto;
import hu.szakdolgozat.tm.dto.CreateComponentDto;
import hu.szakdolgozat.tm.dto.UpdateComponentDto;
import hu.szakdolgozat.tm.entity.ComponentEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.mapper.ComponentMapper;
import hu.szakdolgozat.tm.repository.ComponentRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService {

    private static final ComponentMapper COMPONENT_MAPPER = Mappers.getMapper(ComponentMapper.class);
    
    @Autowired
    private GeneralRepository generalRepository;
    
    @Autowired
    private ComponentRepository componentRepository;
    
    public ComponentServiceImpl() {
    }

    @Override
    public ComponentDto createComponent(CreateComponentDto createDto) throws ServiceException {
        try {
            ComponentEntity componentEntity = COMPONENT_MAPPER.mapCreateComponentDtoToEntity(createDto);
            componentEntity.setCreateDate(new Date());
            
            this.generalRepository.createEntity(componentEntity);
            
            return COMPONENT_MAPPER.mapComponentEntityToDto(componentEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public ComponentDto updateComponent(UpdateComponentDto updateComponentDto) throws ServiceException {
        try {
            ComponentEntity entityToUpdate = this.componentRepository.getComponentEntityById(updateComponentDto.getId());
            setUpdatedFieldsToComponent(entityToUpdate, updateComponentDto);
            
            this.generalRepository.updateEntity(entityToUpdate);
            
            return COMPONENT_MAPPER.mapComponentEntityToDto(entityToUpdate);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteComponent(Long id) throws ServiceException {
        try {
            ComponentEntity componentEntity = this.componentRepository.getComponentEntityById(id);
            
            this.generalRepository.deleteEntity(componentEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ComponentDto> getComponentsByProjectId(Long id) throws ServiceException {
        try {
            return COMPONENT_MAPPER.mapComponentEntityListToDtoList(this.componentRepository.getComponentListByProjectId(id));
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }
    
    @Override
    public ComponentDto getComponentById(Long id) throws ServiceException {
        try {
            ComponentEntity componentEntity = this.componentRepository.getComponentEntityById(id);
            
            return COMPONENT_MAPPER.mapComponentEntityToDto(componentEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }
    
    private void setUpdatedFieldsToComponent(ComponentEntity entityToUpdate, UpdateComponentDto updateComponentDto) {
        entityToUpdate.setName(updateComponentDto.getName());
        entityToUpdate.setDescription(updateComponentDto.getDescription());
        entityToUpdate.setAuthor(updateComponentDto.getAuthor());
        entityToUpdate.setVersion(updateComponentDto.getVersion());
    }

}
