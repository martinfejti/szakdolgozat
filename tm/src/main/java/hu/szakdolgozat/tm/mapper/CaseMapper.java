package hu.szakdolgozat.tm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;
import hu.szakdolgozat.tm.entity.CaseEntity;

@Mapper(uses = StepMapper.class)
public abstract class CaseMapper {

    @Mapping(source = "componentId", target = "component.id")
    public abstract CaseEntity mapCreateCaseDtoToEntity(CreateCaseDto createDto);
    
    @Mapping(source = "component.id", target = "componentId")
    public abstract CaseDto mapCaseEntityToDto(CaseEntity entity);
    
    public abstract List<CaseDto> mapCaseEntityListToDtoList(List<CaseDto> entityList);
}
