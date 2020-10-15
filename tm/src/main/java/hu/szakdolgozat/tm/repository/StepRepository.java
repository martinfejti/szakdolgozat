package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.StepEntity;

public interface StepRepository {

    public StepEntity getStepEntityById(Long id) throws Exception;
    
    public List<StepEntity> getStepEntityListByCaseId(Long id) throws Exception;
    
}
