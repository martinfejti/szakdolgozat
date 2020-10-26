import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Step } from './../models/step';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StepService {

  selectedStepObservable = new Subject();

  constructor(private httpClient: HttpClient) { }

  createStep(step: Step) {
    console.log(step);
    return this.httpClient.post('http://localhost:8080/step', {
      orderNumber: step.orderNumber,
      description: step.description,
      expectedResult: step.expectedResult,
      comment: step.comment,
      caseId: step.caseId
    });
  }

  deleteStep(id: number) {
    return this.httpClient.delete(`http://localhost:8080/step/${id}`, {});
  }

  notifySelectedStep(step: Step) {
    this.selectedStepObservable.next(step);
  }
}
