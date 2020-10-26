import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { Case } from './../../models/case';

@Component({
  selector: 'app-add-case',
  templateUrl: './add-case.component.html',
  styleUrls: ['./add-case.component.scss']
})
export class AddCaseComponent implements OnInit {

  @Input() parentComponent: ComponentModel;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;
  testCase: Case = {
    id: null,
    name: null,
    description: null,
    componentId: null,
    steps: []
  };

  constructor() { }

  ngOnInit() {
  }

  addCase() {
    // call case service
  }

}
