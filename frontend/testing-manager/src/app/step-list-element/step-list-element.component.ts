import { Component, OnInit, Input } from '@angular/core';
import { Step } from './../../models/step';
import { StepService } from './../../services/step.service';

@Component({
  selector: 'app-step-list-element',
  templateUrl: './step-list-element.component.html',
  styleUrls: ['./step-list-element.component.scss']
})
export class StepListElementComponent implements OnInit {

  @Input() step: Step;

  constructor(private stepService: StepService) { }

  ngOnInit() {
  }

  onSelectedStep() {
    this.stepService.notifySelectedStep(this.step);
  }

}
