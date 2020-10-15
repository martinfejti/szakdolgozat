package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.CaseEntity;
import hu.szakdolgozat.tm.repository.CaseRepository;

@Repository
public class CaseRepositoryImpl implements CaseRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public CaseRepositoryImpl() {
    }

    @Override
    public CaseEntity getCaseEntityById(Long id) throws Exception {
        CaseEntity result = null;
        
        try {
            TypedQuery<CaseEntity> query = this.entityManager.createQuery("SELECT c FROM Case c WHERE id = :id", CaseEntity.class);
            query.setParameter("id", id);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return result;
    }

    @Override
    public List<CaseEntity> getCaseEntityListByComponentId(Long id) throws Exception {
        List<CaseEntity> resultList = null;
        
        try {
            TypedQuery<CaseEntity> query = this.entityManager.createQuery("SELECT c FROM Case c WHERE component.id = :id", CaseEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }
}
