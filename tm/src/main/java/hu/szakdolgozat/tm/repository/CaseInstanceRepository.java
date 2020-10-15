package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.CaseInstanceEntity;

public interface CaseInstanceRepository {

    public List<CaseInstanceEntity> getCaseInstanceListByCaseId(Long id) throws Exception;
    
    public List<CaseInstanceEntity> getCaseInstanceListByComponentInstanceId(Long id) throws Exception;
}
