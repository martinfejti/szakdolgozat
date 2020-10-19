package hu.szakdolgozat.tm.service.impl;

import java.util.Date;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.ComponentInstanceDto;
import hu.szakdolgozat.tm.dto.CreateComponentInstanceDto;
import hu.szakdolgozat.tm.entity.ComponentInstanceEntity;
import hu.szakdolgozat.tm.mapper.ComponentInstanceMapper;
import hu.szakdolgozat.tm.repository.ComponentInstanceRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.service.ComponentInstanceService;

@Service
public class ComponentInstanceServiceImpl implements ComponentInstanceService {

    private static final ComponentInstanceMapper COMPONENT_INSTANCE_MAPPER = Mappers.getMapper(ComponentInstanceMapper.class);
    
    @Autowired
    private GeneralRepository generalRepository;
    
    @Autowired
    private ComponentInstanceRepository componentInstanceRepository;
    
    public ComponentInstanceServiceImpl() {
    }

    @Override
    public ComponentInstanceDto createComponentInstance(CreateComponentInstanceDto createDto) throws Exception {
        ComponentInstanceEntity componentInstanceEntity = COMPONENT_INSTANCE_MAPPER.mapCreateComponentInstanceDtoToEntity(createDto);
        componentInstanceEntity.setOpenDate(new Date());
        
        this.generalRepository.createEntity(componentInstanceEntity);
        
        return COMPONENT_INSTANCE_MAPPER.mapComponentInstanceEntityToDto(componentInstanceEntity);
    }

    @Override
    public ComponentInstanceDto closeComponentInstance(Long id) throws Exception {
        ComponentInstanceEntity componentInstanceEntity = this.componentInstanceRepository.getComponentInstanceEntityById(id);
        componentInstanceEntity.setCloseDate(new Date());
        
        this.generalRepository.updateEntity(componentInstanceEntity);
        
        return COMPONENT_INSTANCE_MAPPER.mapComponentInstanceEntityToDto(componentInstanceEntity);
    }

    @Override
    public List<ComponentInstanceDto> getAllComponentInstances() throws Exception {
        List<ComponentInstanceEntity> componentInstanceEntityList = this.componentInstanceRepository.getAllComponentInstances();
        
        return COMPONENT_INSTANCE_MAPPER.mapComponentInstanceEntityListToDtoList(componentInstanceEntityList);
    }

    @Override
    public List<ComponentInstanceDto> getAllComponentInstancesByComponentId(Long id) throws Exception {
        List<ComponentInstanceEntity> componentInstanceEntityList = this.componentInstanceRepository.getComponentInstanceListByComponentId(id);
        
        return COMPONENT_INSTANCE_MAPPER.mapComponentInstanceEntityListToDtoList(componentInstanceEntityList);
    }
}
