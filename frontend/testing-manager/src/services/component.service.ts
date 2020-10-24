import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Component as ComponentModel } from './../models/component';

@Injectable({
  providedIn: 'root'
})
export class ComponentService {

  selectedComponentObservable = new Subject();

  constructor() { }

  notifySelectedComponent(component: ComponentModel) {
    console.log('comp service notify');
    console.log(component);
    this.selectedComponentObservable.next(component);
  }
}
