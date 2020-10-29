package hu.szakdolgozat.tm.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.utils.Constants;

@Transactional
@Repository
public class GeneralRepositoryImpl implements GeneralRepository {

    @PersistenceContext
    private EntityManager entityManager;
    
    public GeneralRepositoryImpl() {
    }
    
    @Override
    public void createEntity(Object object) throws PersistenceException {
        try {
            this.entityManager.persist(object);
            this.entityManager.flush();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.CREATE_FAILED, e);
        }
    }

    @Override
    public void updateEntity(Object object) throws PersistenceException {
        try {
            this.entityManager.merge(object);
            this.entityManager.flush();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.UPDATE_FAILED, e);
        }
    }

    @Override
    public void deleteEntity(Object object) throws PersistenceException {
        try {
            this.entityManager.remove(object);
            this.entityManager.flush();
        } catch (RuntimeException e) {
            throw new PersistenceException(Constants.ErrorMessages.DELETE_FAILED, e);
        }
    }

}
