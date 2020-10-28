import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';

@Component({
  selector: 'app-component-test',
  templateUrl: './component-test.component.html',
  styleUrls: ['./component-test.component.scss']
})
export class ComponentTestComponent implements OnInit {

  @Input() component: ComponentModel;

  constructor() { }

  ngOnInit() {
  }

}
