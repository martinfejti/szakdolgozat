import { Component, OnInit, Input } from '@angular/core';
import { ComponentInstance } from './../../models/component-instance';
import { RunTestService } from './../../services/run-test.service';
import { ComponentService } from './../../services/component.service';

@Component({
  selector: 'app-component-test-results-details',
  templateUrl: './component-test-results-details.component.html',
  styleUrls: ['./component-test-results-details.component.scss']
})
export class ComponentTestResultsDetailsComponent implements OnInit {

  @Input() componentInstance: ComponentInstance;

  constructor(private runTestService: RunTestService, private componentService: ComponentService) { }

  ngOnInit() {
  }

}
