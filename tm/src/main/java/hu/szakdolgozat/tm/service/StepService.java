package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CreateStepDto;
import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.dto.UpdateStepDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface StepService {

    public StepDto createStep(CreateStepDto createDto) throws ServiceException;
    
    public StepDto updateStep(UpdateStepDto updateDto) throws ServiceException;
    
    public void deleteStep(Long id) throws ServiceException;
    
    public List<StepDto> getAllStepsByCaseId(Long id) throws ServiceException;
}
