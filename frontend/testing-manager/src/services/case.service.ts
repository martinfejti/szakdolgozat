import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Case } from './../models/case';
import { HttpClient } from '@angular/common/http';

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

  notifySelectedCase(testCase: Case) {
    console.log(testCase);
    this.selectedCaseObservable.next(testCase);
  }

}
