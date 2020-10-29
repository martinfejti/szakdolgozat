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
    if (this.step.description && this.step.expectedResult) {
      this.stepService.editStep(this.step).subscribe(result => {
        console.log(result);
        this.projectService.notifyProjectEdition();
        this.closeBtn.nativeElement.click();
        alert('Step has been successfully edited!');
      }, error => {
        console.log(error);
        alert('A problem has occured during step edition!');
      });
    } else {
      alert('Description and expected result fields are required to fill!');
    }
  }
}
