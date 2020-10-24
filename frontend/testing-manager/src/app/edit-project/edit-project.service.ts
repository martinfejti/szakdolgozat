import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from './../../models/project';

@Injectable()
export class EditProjectService {

  constructor(private httpClient: HttpClient) { }

  editProject(project: Project) {
    console.log(project);
    return this.httpClient.put('http://localhost:8080/project', {
      id: project.id,
      name: project.name,
      shortDescription: project.shortDescription,
      longDescription: project.longDescription
    });
  }
}
