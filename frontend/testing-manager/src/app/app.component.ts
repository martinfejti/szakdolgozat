import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'testing-manager';
  selectedView: string;

  constructor() {
    this.selectedView = 'PROJECT_DETAILS';
  }

  changeSelectedView(type: 'PROJECT_DETAILS' | 'COMPONENT_DETAILS' | 'CASE_DETAILS' | 'RUN_TEST' | 'USERS_GUIDE' | undefined) {
    this.selectedView = type;
  }
}
