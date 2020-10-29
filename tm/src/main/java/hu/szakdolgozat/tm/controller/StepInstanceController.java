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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szakdolgozat.tm.dto.CreateStepInstanceDto;
import hu.szakdolgozat.tm.dto.StepInstanceDto;
import hu.szakdolgozat.tm.exceptions.ControllerException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.service.StepInstanceService;

@CrossOrigin
@RestController
@RequestMapping("stepInstance")
public class StepInstanceController {

    @Autowired
    private StepInstanceService stepInstanceService;
    
    public StepInstanceController() {
    }
    
    @PostMapping
    public StepInstanceDto createStepInstance(@Valid @RequestBody CreateStepInstanceDto createDto) throws ControllerException {
        try {
            return this.stepInstanceService.createStepInstance(createDto);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/getStepInstancesByCaseInstanceId/{id}")
    public List<StepInstanceDto> getStepInstancesByCaseInstanceId(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.stepInstanceService.getStepInstancesByCaseInstanceId(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/getStepInstancesByStepId/{id}")
    public List<StepInstanceDto> getStepInstancesByStepId(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.stepInstanceService.getStepInstanceByStepId(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
