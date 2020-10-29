package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.CaseInstanceEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.repository.CaseInstanceRepository;
import hu.szakdolgozat.tm.utils.Constants;

@Repository
public class CaseInstanceRepositoryImpl implements CaseInstanceRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public CaseInstanceRepositoryImpl() {
    }

    @Override
    public List<CaseInstanceEntity> getCaseInstanceListByCaseId(Long id) throws PersistenceException {
        List<CaseInstanceEntity> resultList = null;
        
        try {
            TypedQuery<CaseInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM CaseInstance ci WHERE testCase.id = :id", CaseInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return resultList;
    }

    @Override
    public List<CaseInstanceEntity> getCaseInstanceListByComponentInstanceId(Long id) throws PersistenceException {
        List<CaseInstanceEntity> resultList = null;
        
        try {
            TypedQuery<CaseInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM CaseInstance WHERE componentInstance.id = :id", CaseInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return resultList;
    }

    @Override
    public CaseInstanceEntity getCaseInstanceById(Long id) throws PersistenceException {
        CaseInstanceEntity result = null;
        
        try {
            TypedQuery<CaseInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM CaseInstance ci WHERE id = :id", CaseInstanceEntity.class);
            query.setParameter("id", id);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return result;
    }

}
