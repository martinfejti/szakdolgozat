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

import hu.szakdolgozat.tm.dto.ComponentInstanceDto;
import hu.szakdolgozat.tm.dto.CreateComponentInstanceDto;
import hu.szakdolgozat.tm.service.ComponentInstanceService;

@CrossOrigin
@RestController
@RequestMapping("componentInstance")
public class ComponentInstanceController {

    @Autowired
    private ComponentInstanceService componentInstanceService;
    
    public ComponentInstanceController() {
    }
    
    @PostMapping
    public ComponentInstanceDto createComponentInstance(@RequestBody @Valid CreateComponentInstanceDto createDto) throws Exception {
        return this.componentInstanceService.createComponentInstance(createDto);
    }
    
    @PutMapping("/{id}")
    public ComponentInstanceDto closeComponentInstance(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.componentInstanceService.closeComponentInstance(id);
    }
    
    @GetMapping("/{id}")
    public List<ComponentInstanceDto> getComponentInstancesByComponentId(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.componentInstanceService.getAllComponentInstancesByComponentId(id);
    }
    
    @GetMapping("/getAllComponentInstances")
    public List<ComponentInstanceDto> getAllComponentInstances() throws Exception {
        return this.componentInstanceService.getAllComponentInstances();
    }
}
