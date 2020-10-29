import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Case } from './../../models/case';
import { CaseService } from './../../services/case.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-edit-case',
  templateUrl: './edit-case.component.html',
  styleUrls: ['./edit-case.component.scss']
})
export class EditCaseComponent implements OnInit {

  @Input() testCase: Case;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private caseService: CaseService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  editCase() {
    if (this.testCase.name && this.testCase.description) {
      this.caseService.editCase(this.testCase).subscribe(result => {
        console.log(result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectEdition();
        alert('Case has been successfully edited!');
      }, error => {
        console.log(error);
        alert('A problem has occured during case edition!');
      });
    } else {
      alert('Name and short description fields are required!');
    }
  }
}
