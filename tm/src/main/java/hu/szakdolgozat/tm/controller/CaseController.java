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

import hu.szakdolgozat.tm.dto.CaseDto;
import hu.szakdolgozat.tm.dto.CreateCaseDto;
import hu.szakdolgozat.tm.service.CaseService;

@CrossOrigin
@RestController
@RequestMapping("case")
public class CaseController {

    @Autowired
    private CaseService caseService;
    
    public CaseController() {
    }
    
    @PostMapping
    public CaseDto createCase(@Valid @RequestBody CreateCaseDto createDto) throws Exception {
        return this.caseService.createCase(createDto);
    }
    
    @PutMapping
    public CaseDto updateCase(@Valid @RequestBody CaseDto caseDto) throws Exception {
        return this.caseService.updateCase(caseDto);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCase(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        this.caseService.deleteCase(id);
    }
    
    @GetMapping("/{id}")
    public List<CaseDto> getAllCasesByComponentId(@PathVariable @Min(1) @NotNull Long id) throws Exception {
        return this.caseService.getCaseListByComponentId(id);
    }
}
