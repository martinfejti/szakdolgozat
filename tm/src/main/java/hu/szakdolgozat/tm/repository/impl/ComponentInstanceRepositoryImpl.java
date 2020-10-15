package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.ComponentInstanceEntity;
import hu.szakdolgozat.tm.repository.ComponentInstanceRepository;

@Repository
public class ComponentInstanceRepositoryImpl implements ComponentInstanceRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public ComponentInstanceRepositoryImpl() {
    }

    @Override
    public List<ComponentInstanceEntity> getComponentInstanceListByComponentId(Long id) throws Exception {
        List<ComponentInstanceEntity> resultList = null;
        
        try {
            TypedQuery<ComponentInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM ComponentInstance ci WHERE component.id = :id", ComponentInstanceEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }

    @Override
    public List<ComponentInstanceEntity> getAllComponentInstances() throws Exception {
        List<ComponentInstanceEntity> resultList = null;
        
        try {
            TypedQuery<ComponentInstanceEntity> query = this.entityManager.createQuery("SELECT ci FROM ComponentInstance ci", ComponentInstanceEntity.class);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }
}
