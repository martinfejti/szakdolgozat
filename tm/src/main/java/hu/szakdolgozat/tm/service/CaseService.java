package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;

public interface CaseService {

    public CaseDto createCase(CreateCaseDto createDto) throws Exception;
    
    public CaseDto updateCase(CaseDto caseDto) throws Exception;
    
    public void deleteCase(Long id) throws Exception;
    
    public List<CaseDto> getCaseListByComponentId(Long id) throws Exception;
    
}
