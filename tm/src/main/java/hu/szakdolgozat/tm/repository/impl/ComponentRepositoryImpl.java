package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.ComponentEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.repository.ComponentRepository;
import hu.szakdolgozat.tm.utils.Constants;

@Repository
public class ComponentRepositoryImpl implements ComponentRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public ComponentRepositoryImpl() {
    }
    
    @Override
    public ComponentEntity getComponentEntityById(Long id) throws PersistenceException {
        ComponentEntity result = null;
        
        try {
            TypedQuery<ComponentEntity> query = this.entityManager.createQuery("SELECT c FROM Component c WHERE id = :id", ComponentEntity.class);
            query.setParameter("id", id);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return result;
    }

    @Override
    public List<ComponentEntity> getComponentListByProjectId(Long id) throws PersistenceException {
        List<ComponentEntity> resultList = null;
        
        try {
            TypedQuery<ComponentEntity> query = this.entityManager.createQuery("SELECT c FROM Component c WHERE project.id = :id", ComponentEntity.class);
            query.setParameter("id", id);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return resultList;
    }

}
