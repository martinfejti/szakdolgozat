package hu.szakdolgozat.tm.repository;

public interface GeneralRepository {

    public void createEntity(Object object) throws Exception;
    
    public void updateEntity(Object object) throws Exception;
    
    public void deleteEntity(Object object) throws Exception;
}
