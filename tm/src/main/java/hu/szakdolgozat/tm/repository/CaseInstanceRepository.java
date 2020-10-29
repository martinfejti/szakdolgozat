package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.CaseInstanceEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface CaseInstanceRepository {

    public List<CaseInstanceEntity> getCaseInstanceListByCaseId(Long id) throws PersistenceException;
    
    public List<CaseInstanceEntity> getCaseInstanceListByComponentInstanceId(Long id) throws PersistenceException;
    
    public CaseInstanceEntity getCaseInstanceById(Long id) throws PersistenceException;
}
