import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Component as ComponentModel} from './../../models/component';
import { ComponentService } from './../../services/component.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-component-details',
  templateUrl: './component-details.component.html',
  styleUrls: ['./component-details.component.scss']
})
export class ComponentDetailsComponent implements OnInit {

  @Input() component: ComponentModel;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private componentService: ComponentService, private projectService: ProjectService) { }

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
    });
  }

}
