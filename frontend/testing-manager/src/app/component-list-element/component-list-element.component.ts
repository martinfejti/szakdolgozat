import { Component, OnInit, Input } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { ComponentService } from './../../services/component.service';

@Component({
  selector: 'app-component-list-element',
  templateUrl: './component-list-element.component.html',
  styleUrls: ['./component-list-element.component.scss']
})
export class ComponentListElementComponent implements OnInit {

  @Input() component: ComponentModel;

  constructor(private componentService: ComponentService) { }

  ngOnInit() {
  }

  onSelectedComponent(component: ComponentModel) {
    console.log('listabol comp kivalasztgva');
    this.componentService.notifySelectedComponent(this.component);
  }

}
