package hu.szakdolgozat.tm.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szakdolgozat.tm.dto.CreateProjectDto;
import hu.szakdolgozat.tm.dto.ProjectDto;
import hu.szakdolgozat.tm.entity.ProjectEntity;
import hu.szakdolgozat.tm.exceptions.PersistenceException;
import hu.szakdolgozat.tm.exceptions.ServiceException;
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
    public ProjectDto createProject(CreateProjectDto createDto) throws ServiceException {
        try {
            ProjectEntity projectEntity = PROJECT_MAPPER.mapCreateProjectDtoToEntity(createDto);
            
            this.generalRepository.createEntity(projectEntity);
            
            return PROJECT_MAPPER.mapProjectEntityToDto(projectEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) throws ServiceException {
        try {
            ProjectEntity projectEntity = this.projectRepository.getProjectById(projectDto.getId());
            projectEntity.setName(projectDto.getName());
            projectEntity.setShortDescription(projectDto.getShortDescription());
            projectEntity.setLongDescription(projectDto.getLongDescription());
            
            this.generalRepository.updateEntity(projectEntity);
            
            return PROJECT_MAPPER.mapProjectEntityToDto(projectEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteProjectById(Long id) throws ServiceException {
        try {
            ProjectEntity projectEntity = this.projectRepository.getProjectById(id);
            
            this.generalRepository.deleteEntity(projectEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProjectDto> getAllProjects() throws ServiceException {
        try {
            List<ProjectEntity> projectEntityList = this.projectRepository.getAllProjects();
            
            return PROJECT_MAPPER.mapProjectEntitiesToDtoList(projectEntityList);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public ProjectDto getProjectById(Long id) throws ServiceException {
        try {            
            ProjectEntity projectEntity = this.projectRepository.getProjectById(id);
            
            return PROJECT_MAPPER.mapProjectEntityToDto(projectEntity);
        } catch (PersistenceException e) {
            throw new ServiceException(e);
        }
    }

}
