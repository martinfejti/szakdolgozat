import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel} from './../../models/component';
import { ComponentService } from './../../services/component.service';


@Component({
  selector: 'app-component-details',
  templateUrl: './component-details.component.html',
  styleUrls: ['./component-details.component.scss']
})
export class ComponentDetailsComponent implements OnInit {

  @Input() component: ComponentModel;

  constructor(private componentService: ComponentService) { }

  ngOnInit() {
    /*
    console.log('COMP DET BEFORE SUB');
    this.componentService.selectedComponentObservable.subscribe(result => {
      console.log('triggered comp subs');
      this.component = result;
      console.log(this.component);
    });
    */
  }

}
