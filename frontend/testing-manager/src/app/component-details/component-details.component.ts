import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Component as ComponentModel} from './../../models/component';
import { ComponentService } from './../../services/component.service';
import { ProjectService } from './../../services/project.service';
import { ExcelService } from './../../services/excel.service';

@Component({
  selector: 'app-component-details',
  templateUrl: './component-details.component.html',
  styleUrls: ['./component-details.component.scss']
})
export class ComponentDetailsComponent implements OnInit {

  @Input() component: ComponentModel;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private componentService: ComponentService, private projectService: ProjectService, private excelService: ExcelService) { }

  ngOnInit() {
  }

  openTestPage() {
    this.componentService.notifyOpenTestPage(this.component);
  }

  deleteComponent() {
    this.componentService.deleteComponent(this.component.id).subscribe((result) => {
      console.log(result);
      this.projectService.notifyProjectDeletion();
      this.component = null;
      this.closeBtn.nativeElement.click();
      alert('Component has been successfully deleted!');
    }, error => {
      console.log(error);
      alert('A problem has occured during component deletion!');
    });
  }

  exportComponent() {
    if (this.component.testCases.length > 0) {
      this.excelService.exportComponent(this.component.id).subscribe(result => {
        console.log(result);
        alert('Component has been successfully exported to D:\\ driver');
      }, error => {
        console.log(error);
        alert('An error has occured during component export!');
      });
    } else {
      alert('This component has no testcases yet!');
    }
  }

}
