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
    public StepInstanceDto createStepInstance(@Valid @RequestBody CreateStepInstanceDto createDto) throws Exception {
        return this.stepInstanceService.createStepInstance(createDto);
    }
    
    @GetMapping("/getStepInstancesByCaseInstanceId/{id}")
    public List<StepInstanceDto> getStepInstancesByCaseInstanceId(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.stepInstanceService.getStepInstancesByCaseInstanceId(id);
    }
    
    @GetMapping("/getStepInstancesByStepId/{id}")
    public List<StepInstanceDto> getStepInstancesByStepId(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.stepInstanceService.getStepInstanceByStepId(id);
    }
}
