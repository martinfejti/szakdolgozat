package hu.szakdolgozat.tm.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.entity.ProjectEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.repository.ProjectRepository;
import hu.szakdolgozat.tm.utils.Constants;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public ProjectRepositoryImpl() {
    }

    @Override
    public List<ProjectEntity> getAllProjects() throws PersistenceException  {
        List<ProjectEntity> resultList = null;
        
        try {
            TypedQuery<ProjectEntity> query = this.entityManager.createQuery("SELECT p FROM Project p", ProjectEntity.class);
            
            resultList = query.getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return resultList;
    }

    @Override
    public ProjectEntity getProjectById(Long id) throws PersistenceException  {
        ProjectEntity result = null;
        
        try {
            TypedQuery<ProjectEntity> query = this.entityManager.createQuery("SELECT p FROM Project p WHERE id = :id", ProjectEntity.class);
            query.setParameter("id", id);
            
            result = query.getSingleResult();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.QUERY_FAILED, e);
        }
        
        return result;
    }

}
