import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Case } from './../../models/case';
import { Step } from './../../models/step';
import { ProjectService } from './../../services/project.service';
import { StepService } from './../../services/step.service';

@Component({
  selector: 'app-add-step',
  templateUrl: './add-step.component.html',
  styleUrls: ['./add-step.component.scss']
})
export class AddStepComponent implements OnInit {

  @Input() parentCase: Case;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;
  step: Step = {
    id: null,
    orderNumber: null,
    description: null,
    expectedResult: null,
    comment: null,
    stepInstances: [],
    caseId: null
  };
  forbiddenOrderNumbers: number[] = [];
  orderNumberOfNewStep: number;

  constructor(private stepService: StepService, private projectService: ProjectService) { }

  ngOnInit() {
    if (this.parentCase.steps.length > 0) {
      for (const step of this.parentCase.steps) {
        this.forbiddenOrderNumbers.push(step.orderNumber);
      }
      this.orderNumberOfNewStep = this.forbiddenOrderNumbers.pop() + 1;
    } else {
      this.orderNumberOfNewStep = 1;
    }

    console.log(this.orderNumberOfNewStep);
  }

  addStep() {
    if (this.step.description && this.step.expectedResult) {
      this.step.caseId = this.parentCase.id;
      this.step.orderNumber = this.orderNumberOfNewStep;
      this.stepService.createStep(this.step).subscribe(result => {
        console.log(result);
        this.projectService.notifyProjectCreation();
        this.stepService.notifySelectedStep(this.step);
        this.closeBtn.nativeElement.click();
        alert('Step has been successfully created!');
      }, error => {
        console.log(error);
        alert('A problem has occured during step creation!');
      });
    } else {
      alert('Description and expected result fields are required to fill!');
    }
  }

}
