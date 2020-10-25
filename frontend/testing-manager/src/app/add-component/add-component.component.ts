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
  component: ComponentModel = {
    id: null,
    projectId: null,
    name: null,
    description: null,
    author: null,
    version: null,
    cases: null,
    componentInstances: null
  };

  constructor(private componentService: ComponentService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  addComponent() {
    if (this.component.name && this.component.description && this.component.author && this.component.version) {
      this.component.projectId = this.parentProject.id;
      this.componentService.createComponent(this.component).subscribe(result => {
        console.log(result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectCreation();
        this.componentService.notifySelectedComponent(result);
      }, error => {
        console.log(error);
      });
    } else {
      alert('All fields are required to fill!');
    }
  }

}
