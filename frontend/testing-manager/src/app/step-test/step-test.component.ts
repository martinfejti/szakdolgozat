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

  constructor(private runTestService: RunTestService) { }

  ngOnInit() {
    this.runTestService.createCaseInstanceObservable.subscribe(caseResult => {
      this.parentCaseInstance = caseResult;
      console.log('new parent case', this.parentCaseInstance);
    });

  }

  createStepInstance(status: string) {
    this.runTestService.createStepInstance(this.parentCaseInstance, this.step, status).subscribe(result => {
      console.log('Step creeated', result);
    }, error => {
      console.log(error);
    });
  }

}
