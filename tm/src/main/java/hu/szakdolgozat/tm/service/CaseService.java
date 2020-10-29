package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;
import hu.szakdolgozat.tm.dto.UpdateCaseDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface CaseService {

    public CaseDto createCase(CreateCaseDto createDto) throws ServiceException;
    
    public CaseDto updateCase(UpdateCaseDto updateDto) throws ServiceException;
    
    public CaseDto updateStepList(UpdateCaseDto updateDto) throws ServiceException;
    
    public void deleteCase(Long id) throws ServiceException;
    
    public List<CaseDto> getCaseListByComponentId(Long id) throws ServiceException;
    
}
