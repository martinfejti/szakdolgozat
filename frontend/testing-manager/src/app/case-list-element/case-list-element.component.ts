import { Component, OnInit, Input } from '@angular/core';
import { Case } from './../../models/case';
import { CaseService } from './../../services/case.service';

@Component({
  selector: 'app-case-list-element',
  templateUrl: './case-list-element.component.html',
  styleUrls: ['./case-list-element.component.scss']
})
export class CaseListElementComponent implements OnInit {

  @Input() testCase: Case;

  constructor(private caseService: CaseService) { }

  ngOnInit() {
  }

  onSelectedCase() {
    this.caseService.notifySelectedCase(this.testCase);
  }
}
