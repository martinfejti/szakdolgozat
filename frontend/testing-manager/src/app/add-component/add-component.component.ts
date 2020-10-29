import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { ComponentService } from './../../services/component.service';
import { ProjectService } from './../../services/project.service';
import { Project } from './../../models/project';

@Component({
  selector: 'app-add-component',
  templateUrl: './add-component.component.html',
  styleUrls: ['./add-component.component.scss']
})
export class AddComponentComponent implements OnInit {

  @Input() parentProject: Project;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;
  createdComponent: ComponentModel;
  component: ComponentModel = {
    id: null,
    projectId: null,
    name: null,
    description: null,
    author: null,
    version: null,
    testCases: [],
    componentInstances: []
  };

  constructor(private componentService: ComponentService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  addComponent() {
    if (this.component.name && this.component.description && this.component.author && this.component.version) {
      this.component.projectId = this.parentProject.id;
      this.componentService.createComponent(this.component).subscribe(result => {
        console.log(result);
        this.setFieldsToNewComponent(result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectCreation();
        this.componentService.notifySelectedComponent(this.createdComponent);
        alert('Component has been successfully created!');
      }, error => {
        console.log(error);
        alert('A problem has occured during component creation!');
      });
    } else {
      alert('All fields are required to fill!');
    }
  }

  setFieldsToNewComponent(result: any) {
    this.createdComponent = result;
    this.createdComponent.testCases = [];
    this.createdComponent.componentInstances = [];
  }

}
