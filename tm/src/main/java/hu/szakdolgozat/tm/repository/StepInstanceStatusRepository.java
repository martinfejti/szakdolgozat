package hu.szakdolgozat.tm.repository;

import hu.szakdolgozat.tm.entity.StepInstanceStatusEntity;
import hu.szakdolgozat.tm.entity.StepInstanceStatusEnum;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface StepInstanceStatusRepository {

    public StepInstanceStatusEntity getStepInstanceStatusByStatus(StepInstanceStatusEnum statusEnum) throws PersistenceException;
    
}
