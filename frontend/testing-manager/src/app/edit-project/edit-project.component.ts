import { Component, OnInit } from '@angular/core';
import { Project } from './../../models/project';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.scss']
})
export class EditProjectComponent implements OnInit {

  project: Project = {
    name: null,
    shortDescription: null,
    id: null,
    longDescription: null,
    components: null
  };

  constructor() { }

  ngOnInit() {
  }

}
