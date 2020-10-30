package hu.szakdolgozat.tm.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    public void exportProjectIntoExcel(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            this.excelService.exportProjectIntoExcel(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @PostMapping("/exportComponent/{id}")
    public void exportComponentIntoExcel(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            this.excelService.exportComponentIntoExcep(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
