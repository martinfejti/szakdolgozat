import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Case } from './../../models/case';
import { CaseService } from './../../services/case.service';
import { ProjectService } from './../../services/project.service';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { Step } from './../../models/step';

@Component({
  selector: 'app-case-details',
  templateUrl: './case-details.component.html',
  styleUrls: ['./case-details.component.scss']
})
export class CaseDetailsComponent implements OnInit {

  @Input() testCase: Case;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private caseService: CaseService, private projectService: ProjectService) { }

  ngOnInit() {
    this.testCase.steps = this.testCase.steps.sort((a, b) => a.orderNumber - b.orderNumber);
    this.caseService.selectedCaseObservable.subscribe(result => {
      console.log('set new case details', result);
      this.testCase = result;
      this.testCase.steps = this.testCase.steps.sort((a, b) => a.orderNumber - b.orderNumber);
    });
  }

  deleteCase() {
    this.caseService.deleteCase(this.testCase.id).subscribe(result => {
      console.log(result);
      this.projectService.notifyProjectDeletion();
      this.testCase = null;
      this.closeBtn.nativeElement.click();
    }, error => {
      console.log(error);
    });
  }

  drop(event: CdkDragDrop<Step[]>) {
    moveItemInArray(this.testCase.steps, event.previousIndex, event.currentIndex);
    this.caseService.editStepList(this.testCase).subscribe(result => {
      console.log(result);
      console.log('order has changed');
      // this.testCase.steps = this.testCase.steps.sort((a, b) => a.orderNumber - b.orderNumber);
      // console.log('AFTER SORT', this.testCase.steps);
      this.projectService.notifyProjectEdition();
      this.caseService.notifySelectedCase(result);
    }, error => {
      console.log(error);
    });
  }
}
