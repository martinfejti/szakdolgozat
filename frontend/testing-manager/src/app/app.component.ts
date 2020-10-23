import { Component } from '@angular/core';
import { ProjectService } from './../services/project.service';
import { Project } from './../models/project';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'testing-manager';
  selectedView: string;
  projects: Project[];

  constructor(private projectService: ProjectService) {
    this.selectedView = 'PROJECT_DETAILS';
  }

  ngOnInit() {
    this.getAllProjects();

    this.projectService.addedProjectObservable.subscribe(() => {
      this.getAllProjects();
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
