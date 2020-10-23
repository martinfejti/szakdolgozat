import { Component, OnInit, Input } from '@angular/core';
import { Project } from './../../models/project';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.scss']
})
export class ProjectDetailsComponent implements OnInit {

  @Input() project: Project;

  constructor(private projectService: ProjectService) { }

  ngOnInit() {
    this.projectService.selectedProjectObservable.subscribe(result => {
      this.project = result;
    });
  }

}
