package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.CaseInstanceEntity;
import hu.szakdolgozat.tm.repository.CaseInstanceRepository;

@Repository
public class CaseInstanceRepositoryImpl implements CaseInstanceRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public CaseInstanceRepositoryImpl() {
    }

    @Override
    public List<CaseInstanceEntity> getCaseInstanceListByCaseId(Long id) throws Exception {
        List<CaseInstanceEntity> resultList = null;
        
        try {
            TypedQuery<CaseInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM CaseInstance ci WHERE testCase.id = :id", CaseInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }

    @Override
    public List<CaseInstanceEntity> getCaseInstanceListByComponentInstanceId(Long id) throws Exception {
        List<CaseInstanceEntity> resultList = null;
        
        try {
            TypedQuery<CaseInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM CaseInstance WHERE componentInstance.id = :id", CaseInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }

}
