import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { CdkStepper } from '@angular/cdk/stepper';

@Component({
  selector: 'app-component-test',
  templateUrl: './component-test.component.html',
  styleUrls: ['./component-test.component.scss']
})
export class ComponentTestComponent implements OnInit {

  @Input() component: ComponentModel;
  selectedIndex: number;

  constructor() { }

  ngOnInit() {
  }

  onClick(index: number): void {
    this.selectedIndex = index;
  }

}
