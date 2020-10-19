package hu.szakdolgozat.tm.service.impl;

import java.util.Date;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CaseInstanceDto;
import hu.szakdolgozat.tm.dto.CreateCaseInstanceDto;
import hu.szakdolgozat.tm.entity.CaseInstanceEntity;
import hu.szakdolgozat.tm.mapper.CaseInstanceMapper;
import hu.szakdolgozat.tm.repository.CaseInstanceRepository;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.service.CaseInstanceService;

@Service
public class CaseInstanceServiceImpl implements CaseInstanceService {
    
    private static final CaseInstanceMapper CASE_INSTANCE_MAPPER = Mappers.getMapper(CaseInstanceMapper.class);
    
    @Autowired
    private CaseInstanceRepository caseInstanceRepository;
    
    @Autowired
    private GeneralRepository generalRepository;
    
    public CaseInstanceServiceImpl() {
    }

    @Override
    public CaseInstanceDto createCaseInstance(CreateCaseInstanceDto createDto) throws Exception {
        CaseInstanceEntity caseInstanceEntity = CASE_INSTANCE_MAPPER.mapCreateCaseInstanceDtoToEntity(createDto);
        caseInstanceEntity.setOpenDate(new Date());
        
        this.generalRepository.createEntity(caseInstanceEntity);
        
        return CASE_INSTANCE_MAPPER.mapCaseInstanceEntityToDto(caseInstanceEntity);
    }

    @Override
    public CaseInstanceDto closeCaseInstance(Long id) throws Exception {
        CaseInstanceEntity caseInstanceEntity = this.caseInstanceRepository.getCaseInstanceById(id);
        caseInstanceEntity.setCloseDate(new Date());
        
        this.generalRepository.updateEntity(caseInstanceEntity);
        
        return CASE_INSTANCE_MAPPER.mapCaseInstanceEntityToDto(caseInstanceEntity);
    }

    @Override
    public List<CaseInstanceDto> getCaseInstancesByComponentInstanceId(Long id) throws Exception {
        List<CaseInstanceEntity> caseInstanceList = this.caseInstanceRepository.getCaseInstanceListByComponentInstanceId(id);
        
        return CASE_INSTANCE_MAPPER.mapCaseInstanceEntityListToDtoList(caseInstanceList);
    }

    @Override
    public List<CaseInstanceDto> getCaseInstancesByCaseId(Long id) throws Exception {
        List<CaseInstanceEntity> caseInstanceList = this.caseInstanceRepository.getCaseInstanceListByCaseId(id);
        
        return CASE_INSTANCE_MAPPER.mapCaseInstanceEntityListToDtoList(caseInstanceList);
    }
}
