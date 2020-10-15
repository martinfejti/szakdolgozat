package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.StepInstanceEntity;
import hu.szakdolgozat.tm.repository.StepInstanceRepository;

@Repository
public class StepInstanceRepositoryImpl implements StepInstanceRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public StepInstanceRepositoryImpl() {
    }

    @Override
    public List<StepInstanceEntity> getStepInstanceEntityListByStepId(Long id) throws Exception {
        List<StepInstanceEntity> resultList = null;
        
        try {
            TypedQuery<StepInstanceEntity> query = this.entityManager.createQuery("SELECT si FROM StepInstance si WHERE step.id = :id", StepInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }

    @Override
    public List<StepInstanceEntity> getStepInstanceEntityListByCaseInstanceId(Long id) throws Exception {
        List<StepInstanceEntity> resultList = null;
        
        try {
            TypedQuery<StepInstanceEntity> query = this.entityManager.createQuery("SELECT si FROM StepInstance si WHERE caseInstance.id = :id", StepInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }
    
}
