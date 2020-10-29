package hu.szakdolgozat.tm.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.entity.StepInstanceStatusEntity;
import hu.szakdolgozat.tm.entity.StepInstanceStatusEnum;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.repository.StepInstanceStatusRepository;
import hu.szakdolgozat.tm.utils.Constants;

@Service
public class StepInstanceStatusRepositoryImpl implements StepInstanceStatusRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public StepInstanceStatusRepositoryImpl() {
        
    }

    @Override
    public StepInstanceStatusEntity getStepInstanceStatusByStatus(StepInstanceStatusEnum statusEnum) throws PersistenceException {
        StepInstanceStatusEntity result = null;
        
        try {
            TypedQuery<StepInstanceStatusEntity> query = this.entityManager.createQuery("SELECT sts FROM StepInstanceStatus sts WHERE stepInstanceStatus = :statusEnum", StepInstanceStatusEntity.class);
            query.setParameter("statusEnum", statusEnum);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return result;
    }
}
