package hu.szakdolgozat.tm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szakdolgozat.tm.exceptions.ControllerException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.service.ExcelService;

@CrossOrigin
@RestController
@RequestMapping("excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;
    
    public ExcelController() {
    }
    
    @PostMapping("/exportProject/{id}")
    public void exportProjectIntoExcel(@PathVariable Long id) throws ControllerException {
        try {
            this.excelService.exportProjectIntoExcel(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
