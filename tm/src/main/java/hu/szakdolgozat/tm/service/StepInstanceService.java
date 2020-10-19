package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CreateStepInstanceDto;
import hu.szakdolgozat.tm.dto.StepInstanceDto;

public interface StepInstanceService {

    public StepInstanceDto createStepInstance(CreateStepInstanceDto createDto) throws Exception;
    
    public List<StepInstanceDto> getStepInstancesByCaseInstanceId(Long id) throws Exception;
    
    public List<StepInstanceDto> getStepInstanceByStepId(Long id) throws Exception;
    
}
