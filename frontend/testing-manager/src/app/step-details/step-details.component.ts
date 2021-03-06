import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Step } from './../../models/step';
import { StepService } from './../../services/step.service';
import { ProjectService } from './../../services/project.service';
import { CaseService } from './../../services/case.service';

@Component({
  selector: 'app-step-details',
  templateUrl: './step-details.component.html',
  styleUrls: ['./step-details.component.scss']
})
export class StepDetailsComponent implements OnInit {

  @Input() step: Step;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;
  numbers: number[] = [];

  constructor(private stepService: StepService, private projectService: ProjectService, private caseService: CaseService) {
    for (let i = 0; i < 10; i++) {
      this.numbers.push(i);
    }
  }

  ngOnInit() {
  }

  deleteStep() {
    this.stepService.deleteStep(this.step.id).subscribe(result => {
      console.log(result);
      this.projectService.notifyProjectDeletion();
      this.step = null;
      this.closeBtn.nativeElement.click();
      alert('Step has been successfully deleted!');
    }, error => {
      console.log(error);
      alert('A problem has occured during step deletion!');
    });
  }

  backToParent() {
    this.caseService.getParentCaseForStep(this.step.caseId).subscribe(result => {
      console.log(result);
      this.caseService.notifySelectedCase(result);
    }, error => {
      console.log(error);
    });
  }

}
