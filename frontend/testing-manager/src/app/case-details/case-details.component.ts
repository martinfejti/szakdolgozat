import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Case } from './../../models/case';
import { CaseService } from './../../services/case.service';
import { ProjectService } from './../../services/project.service';

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
}