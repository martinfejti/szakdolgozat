import { Component, OnInit, Input } from '@angular/core';
import { Project } from './../../models/project';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-project-list-element',
  templateUrl: './project-list-element.component.html',
  styleUrls: ['./project-list-element.component.scss']
})
export class ProjectListElementComponent implements OnInit {

  @Input() project: Project;

  constructor(private projectService: ProjectService) { }

  ngOnInit() {
  }

  onSelectedProject(project: Project) {
    this.projectService.notifySelectedProject(project);
    console.log('henlo');
  }
}
