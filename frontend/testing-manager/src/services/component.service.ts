import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Component as ComponentModel } from './../models/component';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ComponentService {

  selectedComponentObservable = new Subject();
  openTestPageObservable = new Subject();
  openComponentTestResultsObservable = new Subject();


  constructor(private httpClient: HttpClient) { }

  createComponent(component: ComponentModel) {
    console.log(component);
    return this.httpClient.post('http://localhost:8080/component', {
      name: component.name,
      description: component.description,
      author: component.author,
      version: component.version,
      projectId: component.projectId
    });
  }

  editComponent(component: ComponentModel) {
    console.log(component);
    return this.httpClient.put('http://localhost:8080/component', {
      id: component.id,
      projectId: component.projectId,
      name: component.name,
      description: component.description,
      author: component.author,
      version: component.version
    });
  }

  deleteComponent(id: number) {
    console.log(id);
    return this.httpClient.delete(`http://localhost:8080/component/${id}`, {});
  }

  notifySelectedComponent(component: ComponentModel) {
    console.log('comp service notify');
    console.log(component);
    this.selectedComponentObservable.next(component);
  }

  notifyOpenTestPage(component: ComponentModel) {
    this.openTestPageObservable.next(component);
  }

  notifyOpenComponentTestResults(component: ComponentModel) {
    this.openComponentTestResultsObservable.next(component);
  }

  getComponentById(id: number) {
    return this.httpClient.get(`http://localhost:8080/component/getComponentById/${id}`, {});
  }
}
