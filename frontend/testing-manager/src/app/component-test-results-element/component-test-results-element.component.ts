import { Component, OnInit, Input } from '@angular/core';
import { ComponentInstance } from './../../models/component-instance';
import { Component as ComponentModel } from './../../models/component';
import { RunTestService } from './../../services/run-test.service';

@Component({
  selector: 'app-component-test-results-element',
  templateUrl: './component-test-results-element.component.html',
  styleUrls: ['./component-test-results-element.component.scss']
})
export class ComponentTestResultsElementComponent implements OnInit {

  @Input() componentInstance: ComponentInstance;
  @Input() parentComponent: ComponentModel;
  pieChartData: number[] = [];

  constructor(private runTestService: RunTestService) { }

  ngOnInit() {
    console.log(this.componentInstance);
    // this.setStatusNumbers();
  }

  openResultDetails() {
    console.log(this.componentInstance);
    console.log(this.parentComponent);
    this.runTestService.notifyOpenComponentInstanceResultDetails(this.componentInstance, this.parentComponent);
  }

  setStatusNumbers() {
    let okCounter = 0;
    let nokCounter = 0;
    let errCounter = 0;

    if (this.componentInstance.caseInstances.length > 0) {
      for (const caseInstance of this.componentInstance.caseInstances) {
        if (caseInstance.stepInstances.length > 0) {
          for (const stepInstance of caseInstance.stepInstances) {
            if (stepInstance.status === 'OK') {
              okCounter++;
            }
            if (stepInstance.status === 'NOK') {
              nokCounter++;
            }
            if (stepInstance.status === 'ERR') {
              errCounter++;
            }
          }
        }
      }
    }
    console.log('INSTNACE COLOR DETAILS');
    console.log(okCounter);
    console.log(nokCounter);
    console.log(errCounter);
    console.log(this.pieChartData);
    // this.pieChartData[0] = okCounter;
    // this.pieChartData[1] = nokCounter;
    // this.pieChartData[2] = errCounter;
    this.pieChartData = [okCounter, nokCounter, errCounter];
    console.log(this.pieChartData);
  }
}
