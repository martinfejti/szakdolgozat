package hu.szakdolgozat.tm.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.szakdolgozat.tm.dto.CreateStepDto;
import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.entity.StepEntity;

@Mapper
public abstract class StepMapper {

    @Mapping(source = "caseId", target = "testCase.id")
    public abstract StepEntity mapCreateStepDtoToEntity(CreateStepDto createDto);
    
    @Mapping(source = "testCase.id", target = "caseId")
    public abstract StepDto mapStepEntityToDto(StepEntity entity);
}
