package hu.szakdolgozat.tm.service;

import java.util.List;

import hu.szakdolgozat.tm.dto.CaseInstanceDto;
import hu.szakdolgozat.tm.dto.CreateCaseInstanceDto;
import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface CaseInstanceService {

    public CaseInstanceDto createCaseInstance(CreateCaseInstanceDto createDto) throws ServiceException;
    
    public CaseInstanceDto closeCaseInstance(Long id) throws ServiceException;
    
    public List<CaseInstanceDto> getCaseInstancesByComponentInstanceId(Long id) throws ServiceException;
    
    public List<CaseInstanceDto> getCaseInstancesByCaseId(Long id) throws ServiceException;
    
}
