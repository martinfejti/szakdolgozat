package hu.szakdolgozat.tm.service;

import hu.szakdolgozat.tm.exceptions.ServiceException;

public interface ExcelService {

    public void exportProjectIntoExcel(Long id) throws ServiceException;
    
    public void exportComponentIntoExcep(Long id) throws ServiceException;
    
}
