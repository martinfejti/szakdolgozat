package hu.szakdolgozat.tm.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;
import hu.szakdolgozat.tm.entity.ProjectEntity;
import hu.szakdolgozat.tm.mapper.ProjectMapper;
import hu.szakdolgozat.tm.repository.GeneralRepository;
import hu.szakdolgozat.tm.repository.ProjectRepository;
import hu.szakdolgozat.tm.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    
    private static final ProjectMapper PROJECT_MAPPER = Mappers.getMapper(ProjectMapper.class);
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private GeneralRepository generalRepository;
    
    public ProjectServiceImpl() {
    }

    @Override
    public ProjectDto createProject(CreateProjectDto createDto) throws Exception {
        ProjectEntity projectEntity = PROJECT_MAPPER.mapCreateProjectDtoToEntity(createDto);
        
        this.generalRepository.createEntity(projectEntity);
        
        return PROJECT_MAPPER.mapProjectEntityToDto(projectEntity);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) throws Exception {
        ProjectEntity projectEntity = PROJECT_MAPPER.mapProjectDtoToEntity(projectDto);
        
        this.generalRepository.updateEntity(projectEntity);
        
        return PROJECT_MAPPER.mapProjectEntityToDto(projectEntity);
    }

    @Override
    public void deleteProjectById(Long id) throws Exception {
        ProjectEntity projectEntity = this.projectRepository.getProjectById(id);
        
        this.generalRepository.deleteEntity(projectEntity);
    }

    @Override
    public List<ProjectDto> getAllProjects() throws Exception {
        List<ProjectEntity> projectEntityList = this.projectRepository.getAllProjects();
        
        return PROJECT_MAPPER.mapProjectEntitiesToDtoList(projectEntityList);
    }

    @Override
    public ProjectDto getProjectById(Long id) throws Exception {
        ProjectEntity projectEntity = this.projectRepository.getProjectById(id);
        
        return PROJECT_MAPPER.mapProjectEntityToDto(projectEntity);
    }

}
