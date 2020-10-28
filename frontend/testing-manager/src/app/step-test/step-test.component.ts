import { Component, OnInit, Input } from '@angular/core';
import { Step } from './../../models/step';

@Component({
  selector: 'app-step-test',
  templateUrl: './step-test.component.html',
  styleUrls: ['./step-test.component.scss']
})
export class StepTestComponent implements OnInit {

  @Input() step: Step;

  constructor() { }

  ngOnInit() {
  }

}
