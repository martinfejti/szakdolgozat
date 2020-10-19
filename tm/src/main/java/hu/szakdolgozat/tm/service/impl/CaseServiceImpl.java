package hu.szakdolgozat.tm.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;
import hu.szakdolgozat.tm.dto.UpdateCaseDto;
import hu.szakdolgozat.tm.dto.UpdateStepDto;
import hu.szakdolgozat.tm.entity.CaseEntity;
import hu.szakdolgozat.tm.entity.StepEntity;
import hu.szakdolgozat.tm.mapper.CaseMapper;
import hu.szakdolgozat.tm.repository.CaseRepository;
import hu.szakdolgozat.tm.repository.ComponentRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.repository.StepRepository;
import hu.szakdolgozat.tm.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {
    
    private static final CaseMapper CASE_MAPPER = Mappers.getMapper(CaseMapper.class);
    
    @Autowired
    private GeneralRepository generalRepository;
    
    @Autowired
    private ComponentRepository componentRepository;
    
    @Autowired
    private CaseRepository caseRepository;
    
    @Autowired
    private StepRepository stepRepository;
    
    public CaseServiceImpl() {
    }

    @Override
    public CaseDto createCase(CreateCaseDto createDto) throws Exception {
        CaseEntity caseEntity = CASE_MAPPER.mapCreateCaseDtoToEntity(createDto);
        
        this.generalRepository.createEntity(caseEntity);
        
        for (int i = 0; i < caseEntity.getSteps().size(); i++) {
            caseEntity.getSteps().get(i).setTestCase(caseEntity);
            this.generalRepository.createEntity(caseEntity.getSteps().get(i));
        }
        
        return CASE_MAPPER.mapCaseEntityToDto(caseEntity);
    }

    @Override
    public CaseDto updateCase(UpdateCaseDto updateDto) throws Exception {
        CaseEntity caseEntity = this.caseRepository.getCaseEntityById(updateDto.getId());
        caseEntity.setName(updateDto.getName());
        caseEntity.setDescription(updateDto.getDescription());
        caseEntity.setComponent(this.componentRepository.getComponentEntityById(updateDto.getComponentId()));
        
        this.generalRepository.updateEntity(caseEntity);
        
        if (caseEntity.getSteps().size() == updateDto.getSteps().size()) { // if old and updated case has the same number of steps then its just simple update
            for (int i = 0; i < caseEntity.getSteps().size(); i++) {
                StepEntity stepEntity = this.stepRepository.getStepEntityById(updateDto.getId());
                setUpdatedFieldsToStep(stepEntity, updateDto.getSteps().get(i), caseEntity);
                
                this.generalRepository.updateEntity(stepEntity);
            }
        } else { // if the numbers are different then delete old steps and create new ones from dto
            for (int i = 0; i < caseEntity.getSteps().size(); i++) {
                this.generalRepository.deleteEntity(caseEntity.getSteps().get(i));
            }
            for (int i = 0; i < updateDto.getSteps().size(); i++) {
                StepEntity stepEntity = new StepEntity();
                setUpdatedFieldsToStep(stepEntity, updateDto.getSteps().get(i), caseEntity);
                
                this.generalRepository.createEntity(stepEntity);
            }
        }
        
        // return the steps that were present before the delele-create process (anyway it works)
        return CASE_MAPPER.mapCaseEntityToDto(caseEntity);
    }

    @Override
    public void deleteCase(Long id) throws Exception {
        CaseEntity caseEntity = this.caseRepository.getCaseEntityById(id);
        
        this.generalRepository.deleteEntity(caseEntity);
    }

    @Override
    public List<CaseDto> getCaseListByComponentId(Long id) throws Exception {
        List<CaseEntity> caseEntityList = this.caseRepository.getCaseEntityListByComponentId(id);
        
        return CASE_MAPPER.mapCaseEntityListToDtoList(caseEntityList);
    }

    private void setUpdatedFieldsToStep(StepEntity stepEntity, UpdateStepDto updateStepDto, CaseEntity caseEntity) {
        stepEntity.setDescription(updateStepDto.getDescription());
        stepEntity.setExpectedResult(updateStepDto.getExpectedResult());
        stepEntity.setComment(updateStepDto.getComment());
        stepEntity.setTestCase(caseEntity);
        stepEntity.setOrderNumber(updateStepDto.getOrderNumber());
    }
}
