package hu.szakdolgozat.tm.service.impl;

import java.util.Date;
import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CreateStepInstanceDto;
import hu.szakdolgozat.tm.dto.StepInstanceDto;
import hu.szakdolgozat.tm.entity.StepInstanceEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.mapper.StepInstanceMapper;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.repository.StepInstanceRepository;
import hu.szakdolgozat.tm.repository.StepInstanceStatusRepository;
import hu.szakdolgozat.tm.service.StepInstanceService;

@Service
public class StepInstanceServiceImpl implements StepInstanceService {

    private static final StepInstanceMapper STEP_INSTANCE_MAPPER = Mappers.getMapper(StepInstanceMapper.class);
    
    @Autowired
    private GeneralRepository generalRepository;
    
    @Autowired
    private StepInstanceRepository stepInstanceRepository;
    
    @Autowired
    private StepInstanceStatusRepository stepInstanceStatusRepository;
    
    public StepInstanceServiceImpl() {
    }

    @Override
    public StepInstanceDto createStepInstance(CreateStepInstanceDto createDto) throws ServiceException {
        try {            
            StepInstanceEntity stepInstanceEntity = STEP_INSTANCE_MAPPER.mapCreateStepInstanceDtoToEntity(createDto);
            stepInstanceEntity.setTestDate(new Date());
            stepInstanceEntity.setStepInstanceStatus(this.stepInstanceStatusRepository.getStepInstanceStatusByStatus(createDto.getStatus()));
            
            this.generalRepository.createEntity(stepInstanceEntity);
            
            return STEP_INSTANCE_MAPPER.mapStepInstanceEntityToDto(stepInstanceEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<StepInstanceDto> getStepInstancesByCaseInstanceId(Long id) throws ServiceException {
        try {
            List<StepInstanceEntity> stepInstanceList = this.stepInstanceRepository.getStepInstanceEntityListByCaseInstanceId(id);
            
            return STEP_INSTANCE_MAPPER.mapStepInstanceEntityListToDtoList(stepInstanceList);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<StepInstanceDto> getStepInstanceByStepId(Long id) throws ServiceException {
        try {
            List<StepInstanceEntity> stepInstanceList = this.stepInstanceRepository.getStepInstanceEntityListByStepId(id);
            
            return STEP_INSTANCE_MAPPER.mapStepInstanceEntityListToDtoList(stepInstanceList);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }
}
