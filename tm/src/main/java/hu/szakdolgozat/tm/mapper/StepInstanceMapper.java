package hu.szakdolgozat.tm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.CreateStepInstanceDto;
import hu.szakdolgozat.tm.dto.StepInstanceDto;
import hu.szakdolgozat.tm.entity.StepInstanceEntity;

@Mapper
public abstract class StepInstanceMapper {

    @Mapping(source = "status", target = "stepInstanceStatus.stepInstanceStatus")
    @Mapping(source = "stepId", target = "step.id")
    @Mapping(source = "caseInstanceId", target = "caseInstance.id")
    @Mapping(target = "testDate", ignore = true)
    public abstract StepInstanceEntity mapCreateStepInstanceDtoToEntity(CreateStepInstanceDto createDto);
    
    @Mapping(source = "stepInstanceStatus.stepInstanceStatus", target = "status")
    @Mapping(source = "step.id", target = "stepId")
    @Mapping(source = "caseInstance.id", target = "caseInstanceId")
    public abstract StepInstanceDto mapStepInstanceEntityToDto(StepInstanceEntity entity);
    
    public abstract List<StepInstanceDto> mapStepInstanceEntityListToDtoList(List<StepInstanceEntity> entityList);
    
}
