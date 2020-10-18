package hu.szakdolgozat.tm.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.entity.StepEntity;
import hu.szakdolgozat.tm.mapper.StepMapper;
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
    
    public StepServiceImpl() {
    }

    @Override
    public StepDto updateStep(StepDto stepDto) throws Exception {
        StepEntity stepEntity = STEP_MAPPER.mapStepDtoToEntity(stepDto);
        
        this.generalRepository.updateEntity(stepEntity);
        
        return STEP_MAPPER.mapStepEntityToDto(stepEntity);
    }

    @Override
    public List<StepDto> getAllStepsByCaseId(Long id) throws Exception {
        List<StepEntity> stepEntityList = this.stepRepository.getStepEntityListByCaseId(id);
        
        return STEP_MAPPER.mapStepEntityListToDtoList(stepEntityList);
    }

}
