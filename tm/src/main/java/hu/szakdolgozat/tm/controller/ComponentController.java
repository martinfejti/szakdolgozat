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

import hu.szakdolgozat.tm.dto.ComponentDto;
import hu.szakdolgozat.tm.dto.CreateComponentDto;
import hu.szakdolgozat.tm.dto.UpdateComponentDto;
import hu.szakdolgozat.tm.service.ComponentService;

@CrossOrigin
@RestController
@RequestMapping("component")
public class ComponentController {

    @Autowired
    private ComponentService componentService;
    
    public ComponentController() {
    }
    
    @PostMapping
    public ComponentDto createComponent(@Valid @RequestBody CreateComponentDto createDto) throws Exception {
        return this.componentService.createComponent(createDto);
    }
    
    @PutMapping
    public ComponentDto updateComponent(@Valid @RequestBody UpdateComponentDto updateComponentDto) throws Exception {
        return this.componentService.updateComponent(updateComponentDto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteComponent(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        this.componentService.deleteComponent(id);
    }
    
    @GetMapping("/{id}")
    public List<ComponentDto> getComponentsByProjectId(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.componentService.getComponentsByProjectId(id);
    }
}
