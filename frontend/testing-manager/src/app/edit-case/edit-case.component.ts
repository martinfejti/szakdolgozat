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
    this.caseService.editCase(this.testCase).subscribe(result => {
      console.log(result);
      this.closeBtn.nativeElement.click();
      this.projectService.notifyProjectEdition();
    });
  }
}
