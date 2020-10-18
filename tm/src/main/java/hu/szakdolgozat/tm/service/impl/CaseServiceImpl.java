package hu.szakdolgozat.tm.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;
import hu.szakdolgozat.tm.entity.CaseEntity;
import hu.szakdolgozat.tm.mapper.CaseMapper;
import hu.szakdolgozat.tm.repository.CaseRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.service.CaseService;

@Service
public class CaseServiceImpl implements CaseService {
    
    private static final CaseMapper CASE_MAPPER = Mappers.getMapper(CaseMapper.class);
    
    @Autowired
    private GeneralRepository generalRepository;
    
    @Autowired
    private CaseRepository caseRepository;
    
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
    public CaseDto updateCase(CaseDto caseDto) throws Exception {
        CaseEntity caseEntity = CASE_MAPPER.mapCaseDtoToEntity(caseDto);
        
        this.generalRepository.updateEntity(caseEntity);
        
        for (int i = 0; i < caseEntity.getSteps().size(); i++) {
            this.generalRepository.updateEntity(caseEntity.getSteps().get(i));
        }
        
        // caseEntity.getCaseInstances().clear();
        
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
