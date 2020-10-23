import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from './../../models/project';

@Injectable()
export class AddProjectService {

  constructor(private httpClient: HttpClient) { }

  addProject(project: Project) {
    return this.httpClient.post('http://localhost:8080/project', {
      name: project.name,
      shortDescription: project.shortDescription,
      longDescription: project.longDescription
    });
  }
}
