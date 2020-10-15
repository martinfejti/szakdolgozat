package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.ComponentEntity;
import hu.szakdolgozat.tm.repository.ComponentRepository;

@Repository
public class ComponentRepositoryImpl implements ComponentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public ComponentRepositoryImpl() {
    }
    
    @Override
    public ComponentEntity getComponentEntityById(Long id) throws Exception {
        ComponentEntity result = null;
        
        try {
            TypedQuery<ComponentEntity> query = this.entityManager.createQuery("SELECT c FROM Component c WHERE id = :id", ComponentEntity.class);
            query.setParameter("id", id);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return result;
    }

    @Override
    public List<ComponentEntity> getComponentListByProjectId(Long id) throws Exception {
        List<ComponentEntity> resultList = null;
        
        try {
            TypedQuery<ComponentEntity> query = this.entityManager.createQuery("SELECT c FROM Component c WHERE project.id = :id", ComponentEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new Exception(e);
        }
        
        return resultList;
    }

}
