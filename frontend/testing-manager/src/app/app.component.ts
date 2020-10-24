import { Component } from '@angular/core';
import { ProjectService } from './../services/project.service';
import { Project } from './../models/project';
import { ComponentService } from './../services/component.service';
import { Component as ComponentModel } from './../models/component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'testing-manager';
  selectedView: string;
  projects: Project[];
  selectedComponent: ComponentModel;
  selectedProject: Project;

  constructor(private projectService: ProjectService, private componentService: ComponentService) {
    this.selectedView = 'USERS_GUIDE';
  }

  ngOnInit() {
    this.getAllProjects();

    this.projectService.addedProjectObservable.subscribe(() => {
      this.getAllProjects();
    });

    this.projectService.editedProjectObservable.subscribe(() => {
      this.getAllProjects();
    });

    this.projectService.deletedProjectObservable.subscribe(() => {
      this.getAllProjects();
    });

    this.projectService.selectedProjectObservable.subscribe((result) => {
      console.log('new proiject', result);
      this.selectedProject = result;
      this.selectedView = 'PROJECT_DETAILS';
    });

    this.componentService.selectedComponentObservable.subscribe((result) => {
      this.selectedComponent = result;
      this.selectedView = 'COMPONENT_DETAILS';
    });
  }

  changeSelectedView(type: 'PROJECT_DETAILS' | 'COMPONENT_DETAILS' | 'CASE_DETAILS' | 'RUN_TEST' | 'USERS_GUIDE' | undefined) {
    this.selectedView = type;
  }

  getAllProjects() {
    this.projectService.getAllProjects().subscribe(result => {
      console.log(result);
      this.projects = result;
      console.log('FE projects: ', this.projects);
    }, error => {
      console.log(error);
    });
  }
}
