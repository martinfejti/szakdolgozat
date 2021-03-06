import { Component, OnInit, Input } from '@angular/core';
import { Case } from './../../models/case';
import { RunTestService } from './../../services/run-test.service';
import { ComponentInstance } from './../../models/component-instance';
import { CaseInstance } from './../../models/case-instance';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-case-test',
  templateUrl: './case-test.component.html',
  styleUrls: ['./case-test.component.scss']
})
export class CaseTestComponent implements OnInit {

  @Input() testCase: Case;
  @Input() index: number;
  @Input() numberOfCases: number;
  parentComponentInstance: ComponentInstance;
  newCaseInstance: CaseInstance;

  constructor(private runTestService: RunTestService, private projectService: ProjectService) { }

  ngOnInit() {
    this.runTestService.createComponentInstanceObservable.subscribe(result => {
      this.parentComponentInstance = result;
      console.log('new parent compo inst set', this.parentComponentInstance);
      this.runTestService.createCaseInstance(this.testCase, this.parentComponentInstance).subscribe(newCaseResult => {
        console.log(newCaseResult);
        this.newCaseInstance = newCaseResult;
        console.log('SSSSSSSSSSSSS', this.newCaseInstance);
        this.runTestService.notifyCaseInstanceCreation(this.newCaseInstance);
      });
    });
  }

  createAndCloseCaseInstance(triggerComponentInstanceClose: boolean) {
    if (!triggerComponentInstanceClose) {
      this.runTestService.closeCaseInstance(this.newCaseInstance.id).subscribe(caseResult => {
        console.log(caseResult);
        console.log('case closed');
      }, error => {
        console.log(error);
      });
    } else {
      this.runTestService.notifyClosingComponentInstance(this.parentComponentInstance.id);
      this.projectService.notifyProjectEdition();
    }

  }

}
