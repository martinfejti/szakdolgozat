package hu.szakdolgozat.tm.repository;

import java.util.List;

import hu.szakdolgozat.tm.entity.StepInstanceEntity;

public interface StepInstanceRepository {

    public List<StepInstanceEntity> getStepInstanceEntityListByStepId(Long id) throws Exception;
    
    public List<StepInstanceEntity> getStepInstanceEntityListByCaseInstanceId(Long id) throws Exception;
    
}
