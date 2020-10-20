import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from '../models/project';

@Injectable()
export class ProjectService {

  constructor(private httpClient: HttpClient) { }

  getAllProjects() {
    return this.httpClient.get<Project[]>('http://localhost:8080/project/getAllProjects', {});
  }
}
