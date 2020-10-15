package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.StepEntity;
import hu.szakdolgozat.tm.repository.StepRepository;

@Repository
public class StepRepositoryImpl implements StepRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public StepRepositoryImpl() {
    }

    @Override
    public StepEntity getStepEntityById(Long id) throws Exception {
        StepEntity result = null;
        
        try {
            TypedQuery<StepEntity> query = this.entityManager.createQuery("SELECT s FROM Step s WHERE id = :id", StepEntity.class);
            query.setParameter("id", id);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return result;
    }

    @Override
    public List<StepEntity> getStepEntityListByCaseId(Long id) throws Exception {
        List<StepEntity> resultList = null;
        
        try {
            TypedQuery<StepEntity> query = this.entityManager.createQuery("SELECT s FROM Select s WHERE testCase.id = :id", StepEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }
}
