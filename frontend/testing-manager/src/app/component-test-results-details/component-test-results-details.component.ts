import { Component, OnInit, Input } from '@angular/core';
import { ComponentInstance } from './../../models/component-instance';
import { RunTestService } from './../../services/run-test.service';
import { ComponentService } from './../../services/component.service';
import { ChartOptions, ChartType } from 'chart.js';
import { Color, Label, SingleDataSet } from 'ng2-charts';
import { CaseInstance } from './../../models/case-instance';
import { StepInstance } from './../../models/step-instance';

@Component({
  selector: 'app-component-test-results-details',
  templateUrl: './component-test-results-details.component.html',
  styleUrls: ['./component-test-results-details.component.scss']
})
export class ComponentTestResultsDetailsComponent implements OnInit {

  public pieChartOptions: ChartOptions = {
    responsive: true,
    legend: {
      position: 'top',
    },
    plugins: {
      datalabels: {
        formatter: (value, ctx) => {
          const label = ctx.chart.data.labels[ctx.dataIndex];
          return label;
        },
      },
    }
  };
  public pieChartLabels: Label = ['OK', 'NOK', 'ERR'];
  // public pieChartData2: number[] = [10, 10, 10];
  public pieChartType: ChartType = 'pie';
  public pieChartLegend = true;
  public pieChartColors = [
    {
      backgroundColor: ['rgba(25,201,0,1)', 'rgba(255,255,0,1)', 'rgba(255,0,0,1)'],
    },
  ];


  @Input() componentInstance: ComponentInstance;
  pieChartData: number[] = [];

  constructor(private runTestService: RunTestService, private componentService: ComponentService) { }

  ngOnInit() {
    console.log('TELEVERT KURVA MODAL ON INIT');
    console.log(this.pieChartData);
    this.setStatusNumbers();
  }

  public chartClicked(e: any): void {
    console.log(e);
  }

  public chartHovered(e: any): void {
    console.log(e);
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
    this.pieChartData[0] = okCounter;
    this.pieChartData[1] = nokCounter;
    this.pieChartData[2] = errCounter;
    console.log(this.pieChartData);
  }

}
