package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;
import hu.szakdolgozat.tm.dto.UpdateCaseDto;

public interface CaseService {

    public CaseDto createCase(CreateCaseDto createDto) throws Exception;
    
    public CaseDto updateCase(UpdateCaseDto updateDto) throws Exception;
    
    public CaseDto updateStepList(UpdateCaseDto updateDto) throws Exception;
    
    public void deleteCase(Long id) throws Exception;
    
    public List<CaseDto> getCaseListByComponentId(Long id) throws Exception;
    
}
