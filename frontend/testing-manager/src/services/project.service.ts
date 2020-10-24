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
  deletedProjectObservable = new Subject();
  selectedProjectObservable = new Subject();

  constructor(private httpClient: HttpClient) { }

  getAllProjects() {
    return this.httpClient.get<Project[]>('http://localhost:8080/project/getAllProjects', {});
  }

  deleteProject(id: number) {
    console.log(id);
    return this.httpClient.delete(`http://localhost:8080/project/${id}`, {});
  }

  notifyProjectCreation() {
    this.addedProjectObservable.next();
  }

  notifyProjectEdition() {
    this.editedProjectObservable.next();
  }

  notifyProjectDeletion() {
    this.deletedProjectObservable.next();
  }

  notifySelectedProject(project: Project) {
    this.selectedProjectObservable.next(project);
  }
}
