package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CreateStepInstanceDto;
import hu.szakdolgozat.tm.dto.StepInstanceDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface StepInstanceService {

    public StepInstanceDto createStepInstance(CreateStepInstanceDto createDto) throws ServiceException;
    
    public List<StepInstanceDto> getStepInstancesByCaseInstanceId(Long id) throws ServiceException;
    
    public List<StepInstanceDto> getStepInstanceByStepId(Long id) throws ServiceException;
    
}
