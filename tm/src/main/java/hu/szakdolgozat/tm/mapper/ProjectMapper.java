package hu.szakdolgozat.tm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;
import hu.szakdolgozat.tm.entity.ProjectEntity;

@Mapper(uses = ComponentMapper.class)
public abstract class ProjectMapper {

    public abstract ProjectEntity mapCreateProjectDtoToEntity(CreateProjectDto createDto);
    
    @Mapping(source = "components", target = "componentEntities")
    public abstract ProjectEntity mapProjectDtoToEntity(ProjectDto projectDto);
    
    @Mapping(source = "componentEntities", target = "components")
    public abstract ProjectDto mapProjectEntityToDto(ProjectEntity entity);
    
    public abstract List<ProjectDto> mapProjectEntitiesToDtoList(List<ProjectEntity> entities);
    
}
