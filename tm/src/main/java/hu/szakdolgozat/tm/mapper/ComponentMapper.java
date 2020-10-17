package hu.szakdolgozat.tm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.ComponentDto;
import hu.szakdolgozat.tm.dto.CreateComponentDto;
import hu.szakdolgozat.tm.entity.ComponentEntity;

@Mapper(uses = {CaseMapper.class, ComponentInstanceMapper.class})
public abstract class ComponentMapper {

    @Mapping(target = "createDate", ignore = true)
    @Mapping(source = "projectId", target = "project.id")
    public abstract ComponentEntity mapCreateComponentDtoToEntity(CreateComponentDto createDto);
    
    @Mapping(source = "project.id", target = "projectId")
    @Mapping(source = "caseEntities", target = "testCases")
    public abstract ComponentDto mapComponentEntityToDto(ComponentEntity entity);
    
    public abstract List<ComponentDto> mapComponentEntityListToDtoList(List<ComponentEntity> entityList);
    
}
