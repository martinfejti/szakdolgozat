import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Step } from './../../models/step';
import { StepService } from './../../services/step.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-step-details',
  templateUrl: './step-details.component.html',
  styleUrls: ['./step-details.component.scss']
})
export class StepDetailsComponent implements OnInit {

  @Input() step: Step;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;
  numbers: number[] = [];

  constructor(private stepService: StepService, private projectService: ProjectService) {
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
    });
  }

}
