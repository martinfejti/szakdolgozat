import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { CdkStepper } from '@angular/cdk/stepper';
import { RunTestService } from './../../services/run-test.service';
import { ComponentInstance } from './../../models/component-instance';

@Component({
  selector: 'app-component-test',
  templateUrl: './component-test.component.html',
  styleUrls: ['./component-test.component.scss']
})
export class ComponentTestComponent implements OnInit {

  @Input() component: ComponentModel;
  selectedIndex: number;
  newComponentInstance: ComponentInstance;

  constructor(private runTestService: RunTestService) { }

  ngOnInit() {
    if (this.component) {
      this.runTestService.createComponentInstance(this.component).subscribe(result => {
        console.log('compo inst created');
        this.newComponentInstance = result;
        console.log(this.newComponentInstance);
        this.runTestService.notifyComponentInstanceCreation(this.newComponentInstance);
      }, error => {
        console.log(error);
      });
    }

    this.runTestService.closeComponentInstanceObservable.subscribe(closeComponentInstanceResult => {
      console.log('Close component instance triggered', closeComponentInstanceResult);
      this.closeComponentInstance();
    });
  }

  onClick(index: number): void {
    this.selectedIndex = index;
  }

  closeComponentInstance() {
    this.runTestService.closeComponentInstance(this.newComponentInstance.id).subscribe(result => {
      console.log(result);
      console.log('component instance closed');
      alert('Test has been completed successfully!');
    });
  }
}
