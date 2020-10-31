import { Component, OnInit, Input } from '@angular/core';
import { ComponentInstance } from './../../models/component-instance';

@Component({
  selector: 'app-component-test-results-element',
  templateUrl: './component-test-results-element.component.html',
  styleUrls: ['./component-test-results-element.component.scss']
})
export class ComponentTestResultsElementComponent implements OnInit {

  @Input() componentInstance: ComponentInstance;

  constructor() { }

  ngOnInit() {
    console.log(this.componentInstance);
  }

}
