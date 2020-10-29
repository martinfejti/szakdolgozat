package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.StepInstanceEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.repository.StepInstanceRepository;
import hu.szakdolgozat.tm.utils.Constants;

@Repository
public class StepInstanceRepositoryImpl implements StepInstanceRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public StepInstanceRepositoryImpl() {
    }

    @Override
    public List<StepInstanceEntity> getStepInstanceEntityListByStepId(Long id) throws PersistenceException {
        List<StepInstanceEntity> resultList = null;
        
        try {
            TypedQuery<StepInstanceEntity> query = this.entityManager.createQuery("SELECT si FROM StepInstance si WHERE step.id = :id", StepInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return resultList;
    }

    @Override
    public List<StepInstanceEntity> getStepInstanceEntityListByCaseInstanceId(Long id) throws PersistenceException {
        List<StepInstanceEntity> resultList = null;
        
        try {
            TypedQuery<StepInstanceEntity> query = this.entityManager.createQuery("SELECT si FROM StepInstance si WHERE caseInstance.id = :id", StepInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return resultList;
    }
    
}
