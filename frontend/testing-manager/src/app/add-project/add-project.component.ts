import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { Project } from './../../models/project';
import { AddProjectService } from './add-project.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrls: ['./add-project.component.scss']
})
export class AddProjectComponent implements OnInit {

  project: Project = {
    name: null,
    shortDescription: null,
    id: null,
    longDescription: null,
    components: null
  };
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(@Inject(AddProjectService) private addProjectService: AddProjectService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  addProject() {
    if (this.project.name && this.project.shortDescription) {
      this.addProjectService.addProject(this.project).subscribe(result => {
        console.log('Project created', result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectCreation();
        this.projectService.notifySelectedProject(result);
        alert('Project has been successfully created!');
      }, error => {
        alert('A problem has occured during project creation!');
        console.log(error);
      });
    } else {
      alert('Name and short description fields are required!');
    }
  }

}
