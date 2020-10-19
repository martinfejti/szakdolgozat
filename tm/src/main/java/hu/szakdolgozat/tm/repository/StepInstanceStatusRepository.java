package hu.szakdolgozat.tm.repository;

import hu.szakdolgozat.tm.entity.StepInstanceStatusEntity;
import hu.szakdolgozat.tm.entity.StepInstanceStatusEnum;

public interface StepInstanceStatusRepository {

    public StepInstanceStatusEntity getStepInstanceStatusByStatus(StepInstanceStatusEnum statusEnum) throws Exception;
    
}
