import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';

@Component({
  selector: 'app-component-list-element',
  templateUrl: './component-list-element.component.html',
  styleUrls: ['./component-list-element.component.scss']
})
export class ComponentListElementComponent implements OnInit {

  @Input() component: ComponentModel;

  constructor() { }

  ngOnInit() {
  }

}
