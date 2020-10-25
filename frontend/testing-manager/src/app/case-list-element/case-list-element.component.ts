import { Component, OnInit, Input } from '@angular/core';
import { Case } from './../../models/case';

@Component({
  selector: 'app-case-list-element',
  templateUrl: './case-list-element.component.html',
  styleUrls: ['./case-list-element.component.scss']
})
export class CaseListElementComponent implements OnInit {

  @Input() case: Case;

  constructor() { }

  ngOnInit() {
  }

}
