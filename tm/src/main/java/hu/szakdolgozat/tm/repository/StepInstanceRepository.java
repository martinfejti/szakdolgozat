package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.StepInstanceEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface StepInstanceRepository {

    public List<StepInstanceEntity> getStepInstanceEntityListByStepId(Long id) throws PersistenceException;
    
    public List<StepInstanceEntity> getStepInstanceEntityListByCaseInstanceId(Long id) throws PersistenceException;
    
}
