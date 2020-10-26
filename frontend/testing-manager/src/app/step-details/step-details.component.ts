import { Component, OnInit, Input } from '@angular/core';
import { Step } from './../../models/step';

@Component({
  selector: 'app-step-details',
  templateUrl: './step-details.component.html',
  styleUrls: ['./step-details.component.scss']
})
export class StepDetailsComponent implements OnInit {

  @Input() step: Step;

  constructor() { }

  ngOnInit() {
  }

}
