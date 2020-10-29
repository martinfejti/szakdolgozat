import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { Case } from './../../models/case';
import { CaseService } from './../../services/case.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-add-case',
  templateUrl: './add-case.component.html',
  styleUrls: ['./add-case.component.scss']
})
export class AddCaseComponent implements OnInit {

  @Input() parentComponent: ComponentModel;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;
  testCase: Case = {
    id: null,
    name: null,
    description: null,
    componentId: null,
    steps: []
  };

  constructor(private caseService: CaseService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  addCase() {
    if (this.testCase.name && this.testCase.description) {
      this.testCase.componentId = this.parentComponent.id;
      this.caseService.createCase(this.testCase).subscribe(result => {
        console.log(result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectCreation();
        this.caseService.notifySelectedCase(this.testCase);
        alert('Case has been successfully created!');
      }, error => {
        console.log(error);
        alert('A problem has occured during case creation!');
      });
    } else {
      alert('Name and short description fields are required!');
    }
  }

}
