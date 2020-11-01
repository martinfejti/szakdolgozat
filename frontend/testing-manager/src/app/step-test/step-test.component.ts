import { Component, OnInit, Input } from '@angular/core';
import { Step } from './../../models/step';
import { RunTestService } from './../../services/run-test.service';
import { CaseInstance } from './../../models/case-instance';

@Component({
  selector: 'app-step-test',
  templateUrl: './step-test.component.html',
  styleUrls: ['./step-test.component.scss']
})
export class StepTestComponent implements OnInit {

  @Input() step: Step;
  parentCaseInstance: CaseInstance;
  isStepDone = false;
  stepInstanceStatus: string;
  stepComment: string;

  constructor(private runTestService: RunTestService) { }

  ngOnInit() {
    this.runTestService.createCaseInstanceObservable.subscribe(caseResult => {
      this.parentCaseInstance = caseResult;
      console.log('new parent case', this.parentCaseInstance);
    });

  }

  /*
  createStepInstance(status: string) {
    if (!this.isStepDone) {
      this.isStepDone = true;
      this.runTestService.createStepInstance(this.parentCaseInstance, this.step, status).subscribe(result => {
        console.log('Step creeated', result);
      }, error => {
        console.log(error);
      });
    } else {
      alert('Tha step instance has already been created!');
    }
  }*/

  setStepInstanceStatus(statusString: string) {
    if (this.isStepDone !== true) {
      this.stepInstanceStatus = statusString;
    } else {
      alert('Step test is already finished!');
    }
  }

  changeCheckbox(event: any) {
    if (this.isStepDone === false && this.stepInstanceStatus) {
      this.runTestService.createStepInstance(this.parentCaseInstance, this.step, this.stepInstanceStatus, this.stepComment)
      .subscribe(result => {
        console.log(result);
        this.isStepDone = true;
      });
    } else if (this.isStepDone === true) {
      alert('Step test is already finished!');
    } else if (!this.stepInstanceStatus) {
      alert('Please select an outcome according to your test result!');
    }
  }

}
