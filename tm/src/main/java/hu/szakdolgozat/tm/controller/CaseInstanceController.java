package hu.szakdolgozat.tm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szakdolgozat.tm.dto.CaseInstanceDto;
import hu.szakdolgozat.tm.dto.CreateCaseInstanceDto;
import hu.szakdolgozat.tm.exceptions.ControllerException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.service.CaseInstanceService;

@CrossOrigin
@RestController
@RequestMapping("caseInstance")
public class CaseInstanceController {

    @Autowired
    private CaseInstanceService caseInstanceService;
    
    public CaseInstanceController() {
    }
    
    @PostMapping
    public CaseInstanceDto createCaseInstance(@RequestBody @Valid CreateCaseInstanceDto createDto) throws ControllerException {
        try {
            return this.caseInstanceService.createCaseInstance(createDto);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @PutMapping("/{id}")
    public CaseInstanceDto closeComponentInstance(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.caseInstanceService.closeCaseInstance(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/getCaseInstancesByComponentInstanceId/{id}")
    public List<CaseInstanceDto> getCaseInstancesByComponentInstanceId(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.caseInstanceService.getCaseInstancesByComponentInstanceId(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/getCaseInstancesByCaseId/{id}")
    public List<CaseInstanceDto> getCaseInstancesByCaseId(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.caseInstanceService.getCaseInstancesByCaseId(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
