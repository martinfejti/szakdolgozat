import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Step } from './../models/step';

@Injectable({
  providedIn: 'root'
})
export class StepService {

  selectedStepObservable = new Subject();

  constructor() { }

  notifySelectedStep(step: Step) {
    this.selectedStepObservable.next(step);
  }
}
