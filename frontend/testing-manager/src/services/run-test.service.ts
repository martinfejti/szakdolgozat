import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ComponentInstance } from './../models/component-instance';
import { CaseInstance } from './../models/case-instance';
import { Step } from './../models/step';
import { Component as ComponentModel } from './../models/component';
import { Case } from './../models/case';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RunTestService {

  createComponentInstanceObservable = new Subject();
  createCaseInstanceObservable = new Subject();
  closeComponentInstanceObservable = new Subject();
  openComponentInstanceDetailsObservable = new Subject();

  constructor(private httpClient: HttpClient) { }

  createComponentInstance(component: ComponentModel) {
    return this.httpClient.post('http://localhost:8080/componentInstance', {
      componentId: component.id
    });
  }

  createCaseInstance(testCase: Case, parentComponentInstance: ComponentInstance) {
    console.log(testCase);
    console.log(parentComponentInstance);
    return this.httpClient.post('http://localhost:8080/caseInstance', {
      caseId: testCase.id,
      componentInstanceId: parentComponentInstance.id
    });
  }

  createStepInstance(parentCaseInstance: CaseInstance, step: Step, statusString: string) {
    return this.httpClient.post('http://localhost:8080/stepInstance', {
      stepId: step.id,
      caseInstanceId: parentCaseInstance.id,
      status: statusString
    });
  }

  closeComponentInstance(id: number) {
    return this.httpClient.put(`http://localhost:8080/componentInstance/${id}`, {});
  }

  closeCaseInstance(id: number) {
    return this.httpClient.put(`http://localhost:8080/caseInstance/${id}`, {});
  }

  notifyComponentInstanceCreation(componentInstance: ComponentInstance) {
    this.createComponentInstanceObservable.next(componentInstance);
  }

  notifyCaseInstanceCreation(caseInstance: CaseInstance) {
    this.createCaseInstanceObservable.next(caseInstance);
  }

  notifyClosingComponentInstance(id: number) {
    this.closeComponentInstanceObservable.next(id);
  }

  notifyOpenComponentInstanceDetails(componentInstance: ComponentInstance) {
    this.openComponentInstanceDetailsObservable.next(componentInstance);
  }
}
