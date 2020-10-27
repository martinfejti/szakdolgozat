package hu.szakdolgozat.tm.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CreateStepDto;
import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.dto.UpdateStepDto;
import hu.szakdolgozat.tm.entity.CaseEntity;
import hu.szakdolgozat.tm.entity.StepEntity;
import hu.szakdolgozat.tm.mapper.StepMapper;
import hu.szakdolgozat.tm.repository.CaseRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.repository.StepRepository;
import hu.szakdolgozat.tm.service.StepService;

@Service
public class StepServiceImpl implements StepService {
    
    private static final StepMapper STEP_MAPPER = Mappers.getMapper(StepMapper.class);
    
    @Autowired
    private GeneralRepository generalRepository;
    
    @Autowired
    private StepRepository stepRepository;
    
    @Autowired
    private CaseRepository caseRepository;
    
    public StepServiceImpl() {
    }

    @Override
    public StepDto createStep(CreateStepDto createDto) throws Exception {
        StepEntity stepEntity = STEP_MAPPER.mapCreateStepDtoToEntity(createDto);
        
        this.generalRepository.createEntity(stepEntity);
        
        return STEP_MAPPER.mapStepEntityToDto(stepEntity);
    }
    
    @Override
    public StepDto updateStep(UpdateStepDto updateDto) throws Exception {
        StepEntity stepEntity = this.stepRepository.getStepEntityById(updateDto.getId());
        stepEntity.setDescription(updateDto.getDescription());
        stepEntity.setExpectedResult(updateDto.getExpectedResult());
        stepEntity.setComment(updateDto.getComment());
        
        this.generalRepository.updateEntity(stepEntity);
        
        return STEP_MAPPER.mapStepEntityToDto(stepEntity);
    }

    @Override
    public void deleteStep(Long id) throws Exception {
        StepEntity stepEntityToDelete = this.stepRepository.getStepEntityById(id);
        CaseEntity parentCaseEntityBeforeStepDelete = this.caseRepository.getCaseEntityById(stepEntityToDelete.getTestCase().getId());
        
        this.generalRepository.deleteEntity(stepEntityToDelete);
        this.generalRepository.updateEntity(parentCaseEntityBeforeStepDelete);
        
        CaseEntity parentCaseEntityAfterStepDelete = this.caseRepository.getCaseEntityById(parentCaseEntityBeforeStepDelete.getId());
        
        for (int i = 0; i < parentCaseEntityAfterStepDelete.getSteps().size(); i++) {
            StepEntity stepEntity = this.stepRepository.getStepEntityById(parentCaseEntityAfterStepDelete.getSteps().get(i).getId());
            stepEntity.setOrderNumber(i + 1);
            this.generalRepository.updateEntity(stepEntity);
        }
        
        this.generalRepository.updateEntity(parentCaseEntityAfterStepDelete);
    }
    
    @Override
    public List<StepDto> getAllStepsByCaseId(Long id) throws Exception {
        List<StepEntity> stepEntityList = this.stepRepository.getStepEntityListByCaseId(id);
        
        return STEP_MAPPER.mapStepEntityListToDtoList(stepEntityList);
    }

}
