package hu.szakdolgozat.tm.repository;

import hu.szakdolgozat.tm.exceptions.PersistenceException;

public interface GeneralRepository {

    public void createEntity(Object object) throws PersistenceException;
    
    public void updateEntity(Object object) throws PersistenceException;
    
    public void deleteEntity(Object object) throws PersistenceException;
}
