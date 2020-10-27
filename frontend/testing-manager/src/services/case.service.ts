import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Case } from './../models/case';
import { HttpClient } from '@angular/common/http';
import { Step } from './../models/step';

@Injectable({
  providedIn: 'root'
})
export class CaseService {

  selectedCaseObservable = new Subject();

  constructor(private httpClient: HttpClient) { }

  createCase(testCase: Case) {
    return this.httpClient.post('http://localhost:8080/case', {
      name: testCase.name,
      description: testCase.description,
      componentId: testCase.componentId
    });
  }

  editCase(testCase: Case) {
    return this.httpClient.put('http://localhost:8080/case', {
      id: testCase.id,
      name: testCase.name,
      description: testCase.description,
      componentId: testCase.componentId
    });
  }

  editStepList(testCase: Case) {
    console.log(testCase);
    for (let i = 0; i < testCase.steps.length; i++) {
      testCase.steps[i].orderNumber = i + 1;
    }
    console.log('ordered list', testCase);
    return this.httpClient.put('http://localhost:8080/case/editStepList', {
      id: testCase.id,
      name: testCase.name,
      description: testCase.description,
      componentId: testCase.componentId,
      steps: testCase.steps
    });
  }

  deleteCase(id: number) {
    return this.httpClient.delete(`http://localhost:8080/case/${id}`, {});
  }

  notifySelectedCase(testCase: Case) {
    console.log(testCase);
    this.selectedCaseObservable.next(testCase);
  }

}
