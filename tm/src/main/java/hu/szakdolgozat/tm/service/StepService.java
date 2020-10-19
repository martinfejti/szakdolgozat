package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.dto.UpdateStepDto;

public interface StepService {

    public StepDto updateStep(UpdateStepDto updateDto) throws Exception;
    
    public List<StepDto> getAllStepsByCaseId(Long id) throws Exception;
}
