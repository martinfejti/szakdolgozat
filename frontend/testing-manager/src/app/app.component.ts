import { Component } from '@angular/core';
import { ProjectService } from './../services/project.service';
import { Project } from './../models/project';
import { ComponentService } from './../services/component.service';
import { Component as ComponentModel } from './../models/component';
import { CaseService } from './../services/case.service';
import { Case } from './../models/case';
import { StepService } from './../services/step.service';
import { Step } from './../models/step';

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
  selectedCase: Case;
  selectedStep: Step;
  componentForTest: ComponentModel;

  constructor(
    private projectService: ProjectService,
    private componentService: ComponentService,
    private caseService: CaseService,
    private stepService: StepService) {
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
      console.log('NEW COMPO APP COMP', result);
      this.selectedComponent = result;
      this.selectedView = 'COMPONENT_DETAILS';
    });

    this.caseService.selectedCaseObservable.subscribe(result => {
      console.log('new case', result);
      this.selectedCase = result;
      this.selectedView = 'CASE_DETAILS';
    });
    this.stepService.selectedStepObservable.subscribe(result => {
      console.log('new step', result);
      this.selectedStep = result;
      this.selectedView = 'STEP_DETAILS';
    });

    this.componentService.openTestPageObservable.subscribe(result => {
      this.componentForTest = result;
      this.selectedView = 'RUN_TEST';
    });
  }

  changeSelectedView(type: 'PROJECT_DETAILS' | 'COMPONENT_DETAILS' | 'CASE_DETAILS' | 'STEP_DETAILS' | 'RUN_TEST' | 'USERS_GUIDE' | undefined) {
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
