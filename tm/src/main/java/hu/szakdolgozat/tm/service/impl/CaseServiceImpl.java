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
import hu.szakdolgozat.tm.mapper.StepMapper;
import hu.szakdolgozat.tm.repository.CaseRepository;
import hu.szakdolgozat.tm.repository.ComponentRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.repository.StepRepository;
import hu.szakdolgozat.tm.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {
    
    private static final CaseMapper CASE_MAPPER = Mappers.getMapper(CaseMapper.class);
    private static final StepMapper STEP_MAPPER = Mappers.getMapper(StepMapper.class);
    
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
        
        if (caseEntity.getSteps() != null) {
            for (int i = 0; i < caseEntity.getSteps().size(); i++) {
                caseEntity.getSteps().get(i).setTestCase(caseEntity);
                this.generalRepository.createEntity(caseEntity.getSteps().get(i));
            }            
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
        
        return CASE_MAPPER.mapCaseEntityToDto(caseEntity);
    }
    
    @Override
    public CaseDto updateStepList(UpdateCaseDto updateDto) throws Exception {
        CaseEntity caseEntity = this.caseRepository.getCaseEntityById(updateDto.getId());
        
        for (int i = 0; i < updateDto.getSteps().size(); i++) {
            StepEntity stepEntity = this.stepRepository.getStepEntityById(updateDto.getSteps().get(i).getId());
            stepEntity.setOrderNumber(updateDto.getSteps().get(i).getOrderNumber());
            
            this.generalRepository.updateEntity(stepEntity);
        }
        this.generalRepository.updateEntity(caseEntity);
        
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
}
