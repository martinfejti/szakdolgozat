package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CaseInstanceDto;
import hu.szakdolgozat.tm.dto.CreateCaseInstanceDto;

public interface CaseInstanceService {

    public CaseInstanceDto createCaseInstance(CreateCaseInstanceDto createDto) throws Exception;
    
    public CaseInstanceDto closeCaseInstance(Long id) throws Exception;
    
    public List<CaseInstanceDto> getCaseInstancesByComponentInstanceId(Long id) throws Exception;
    
    public List<CaseInstanceDto> getCaseInstancesByCaseId(Long id) throws Exception;
    
}
