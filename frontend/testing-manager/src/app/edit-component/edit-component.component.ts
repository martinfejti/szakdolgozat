import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Component as ComponentModel } from './../../models/component';
import { ComponentService } from './../../services/component.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-edit-component',
  templateUrl: './edit-component.component.html',
  styleUrls: ['./edit-component.component.scss']
})
export class EditComponentComponent implements OnInit {

  @Input() component: ComponentModel;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private componentService: ComponentService, private projectService: ProjectService) { }

  ngOnInit() {
  }

  editComponent() {
    if (this.component.name && this.component.description && this.component.author && this.component.version) {
      this.componentService.editComponent(this.component).subscribe(result => {
        console.log(result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectEdition();
        alert('Component has been successfully edited!');
      }, error => {
        console.log(error);
        alert('A problem has occured during component creation!');
      });
    } else {
      alert('All fields are required to fill!');
    }
  }
}
