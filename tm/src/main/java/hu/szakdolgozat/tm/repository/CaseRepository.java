package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.CaseEntity;

public interface CaseRepository {

    public CaseEntity getCaseEntityById(Long id) throws Exception;
    
    public List<CaseEntity> getCaseEntityListByComponentId(Long id) throws Exception;
    
}
