import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from '../models/project';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  addedProjectObservable = new Subject();
  editedProjectObservable = new Subject();
  selectedProjectObservable = new Subject();

  constructor(private httpClient: HttpClient) { }

  getAllProjects() {
    return this.httpClient.get<Project[]>('http://localhost:8080/project/getAllProjects', {});
  }

  notifyProjectCreation() {
    this.addedProjectObservable.next();
  }

  notifyProjectEdition() {
    this.editedProjectObservable.next();
  }

  notifySelectedProject(project: Project) {
    this.selectedProjectObservable.next(project);
  }
}
