import { Component, OnInit, Input } from '@angular/core';
import { Case } from './../../models/case';

@Component({
  selector: 'app-case-details',
  templateUrl: './case-details.component.html',
  styleUrls: ['./case-details.component.scss']
})
export class CaseDetailsComponent implements OnInit {

  @Input() testCase: Case;

  constructor() { }

  ngOnInit() {
  }

}
