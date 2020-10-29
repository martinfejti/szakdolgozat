package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.StepEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface StepRepository {

    public StepEntity getStepEntityById(Long id) throws PersistenceException;
    
    public List<StepEntity> getStepEntityListByCaseId(Long id) throws PersistenceException;
    
}
