package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.CaseEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface CaseRepository {

    public CaseEntity getCaseEntityById(Long id) throws PersistenceException;
    
    public List<CaseEntity> getCaseEntityListByComponentId(Long id) throws PersistenceException;
    
}
