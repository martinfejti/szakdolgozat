import { Component, OnInit, Input } from '@angular/core';
import { Project } from './../../models/project';

@Component({
  selector: 'app-project-list-element',
  templateUrl: './project-list-element.component.html',
  styleUrls: ['./project-list-element.component.scss']
})
export class ProjectListElementComponent implements OnInit {

  @Input() project: Project;

  constructor() { }

  ngOnInit() {
  }

}
