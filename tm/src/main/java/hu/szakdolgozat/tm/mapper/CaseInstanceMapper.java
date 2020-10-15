package hu.szakdolgozat.tm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.CaseInstanceDto;
import hu.szakdolgozat.tm.dto.CreateCaseInstanceDto;
import hu.szakdolgozat.tm.entity.CaseInstanceEntity;

@Mapper(uses = StepInstanceMapper.class)
public abstract class CaseInstanceMapper {

    @Mapping(source = "caseId", target = "testCase.id")
    @Mapping(source = "componentInstanceId", target = "componentInstance.id")
    @Mapping(target = "openDate", ignore = true)
    public abstract CaseInstanceEntity mapCreateCaseInstanceDtoToEntity(CreateCaseInstanceDto createDto);
    
    @Mapping(source = "testCase.id", target = "caseId")
    @Mapping(source = "componentInstance.id", target = "componentInstanceId")
    public abstract CaseInstanceDto mapCaseInstanceEntityToDto(CaseInstanceEntity entity);
}
