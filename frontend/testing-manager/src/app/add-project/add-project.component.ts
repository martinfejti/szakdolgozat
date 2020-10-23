import { Component, OnInit, Inject, ViewChild, ElementRef } from '@angular/core';
import { Project } from './../../models/project';
import { AddProjectService } from './add-project.service';

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

  constructor(@Inject(AddProjectService) private addProjectService: AddProjectService) { }

  ngOnInit() {
  }

  addProject() {
    this.addProjectService.addProject(this.project).subscribe(result => {
      console.log('Project created', result);
      this.closeBtn.nativeElement.click();
    }, error => {
      console.log(error);
    });
  }

}
