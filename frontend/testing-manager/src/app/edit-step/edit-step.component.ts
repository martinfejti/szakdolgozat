import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Step } from './../../models/step';
import { StepService } from './../../services/step.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-edit-step',
  templateUrl: './edit-step.component.html',
  styleUrls: ['./edit-step.component.scss']
})
export class EditStepComponent implements OnInit {

  @Input() step: Step;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private stepService: StepService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  editStep() {
    this.stepService.editStep(this.step).subscribe(result => {
      console.log(result);
      this.projectService.notifyProjectEdition();
      this.closeBtn.nativeElement.click();
    }, error => {
      console.log(error);
    });
  }

}
