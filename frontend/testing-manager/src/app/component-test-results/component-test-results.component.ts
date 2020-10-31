import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { RunTestService } from './../../services/run-test.service';

@Component({
  selector: 'app-component-test-results',
  templateUrl: './component-test-results.component.html',
  styleUrls: ['./component-test-results.component.scss']
})
export class ComponentTestResultsComponent implements OnInit {

  @Input() component: ComponentModel;

  constructor(private runTestService: RunTestService) { }

  ngOnInit() {
  }

}
