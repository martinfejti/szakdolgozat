package hu.szakdolgozat.tm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;
import hu.szakdolgozat.tm.entity.ProjectEntity;

@Mapper(uses = ComponentMapper.class)
public abstract class ProjectMapper {

    public abstract ProjectEntity mapCreateProjectDtoToEntity(CreateProjectDto createDto);
    
    @Mapping(source = "componentEntities", target = "components")
    public abstract ProjectDto mapProjectEntityToDto(ProjectEntity entity);
}
