package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.StepDto;

public interface StepService {

    public StepDto updateStep(StepDto stepDto) throws Exception;
    
    public List<StepDto> getAllStepsByCaseId(Long id) throws Exception;
}
