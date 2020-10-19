package hu.szakdolgozat.tm.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.szakdolgozat.tm.dto.StepDto;
import hu.szakdolgozat.tm.dto.UpdateStepDto;
import hu.szakdolgozat.tm.service.StepService;

@CrossOrigin
@RestController
@RequestMapping("step")
public class StepController {

    @Autowired
    private StepService stepService;
    
    public StepController() {
    }
    
    @PutMapping
    public StepDto updateStep(@RequestBody @Valid UpdateStepDto updateDto) throws Exception {
        return this.stepService.updateStep(updateDto);
    }
    
    @GetMapping("/{id}")
    public List<StepDto> getStepListByCaseId(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.stepService.getAllStepsByCaseId(id);
    }
}
