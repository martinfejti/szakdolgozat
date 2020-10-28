import { Component, OnInit, Input } from '@angular/core';
import { Case } from './../../models/case';

@Component({
  selector: 'app-case-test',
  templateUrl: './case-test.component.html',
  styleUrls: ['./case-test.component.scss']
})
export class CaseTestComponent implements OnInit {

  @Input() testCase: Case;
  @Input() index: number;

  constructor() { }

  ngOnInit() {
  }

}
