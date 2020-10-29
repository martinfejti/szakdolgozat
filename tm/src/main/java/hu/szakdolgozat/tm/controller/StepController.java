package hu.szakdolgozat.tm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szakdolgozat.tm.dto.CreateStepDto;
import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.dto.UpdateStepDto;
import hu.szakdolgozat.tm.exceptions.ControllerException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
import hu.szakdolgozat.tm.service.StepService;

@CrossOrigin
@RestController
@RequestMapping("step")
public class StepController {

    @Autowired
    private StepService stepService;
    
    public StepController() {
    }
    
    @PostMapping
    public StepDto createStep(@RequestBody @Valid CreateStepDto createDto) throws ControllerException {
        try {
            return this.stepService.createStep(createDto);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @PutMapping
    public StepDto updateStep(@RequestBody @Valid UpdateStepDto updateDto) throws ControllerException {
        try {
            return this.stepService.updateStep(updateDto);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @DeleteMapping("/{id}")
    public void deleteStep(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            this.stepService.deleteStep(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    
    @GetMapping("/{id}")
    public List<StepDto> getStepListByCaseId(@PathVariable @Min(1) @NotNull Long id) throws ControllerException {
        try {
            return this.stepService.getAllStepsByCaseId(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
