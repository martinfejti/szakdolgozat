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

  notifySelectedCase(testCase: Case) {
    console.log(testCase);
    this.selectedCaseObservable.next(testCase);
  }

}
