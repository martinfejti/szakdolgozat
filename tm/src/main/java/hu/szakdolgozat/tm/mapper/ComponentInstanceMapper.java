package hu.szakdolgozat.tm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.ComponentInstanceDto;
import hu.szakdolgozat.tm.dto.CreateComponentInstanceDto;
import hu.szakdolgozat.tm.entity.ComponentInstanceEntity;

@Mapper(uses = CaseInstanceMapper.class)
public abstract class ComponentInstanceMapper {

    @Mapping(source = "componentId", target = "component.id")
    @Mapping(target = "openDate", ignore = true)
    public abstract ComponentInstanceEntity mapCreateComponentInstanceDtoToEntity(CreateComponentInstanceDto createDto);
    
    @Mapping(source = "component.id", target = "componentId")
    public abstract ComponentInstanceDto mapComponentInstanceEntityToDto(ComponentInstanceEntity entity);
}
