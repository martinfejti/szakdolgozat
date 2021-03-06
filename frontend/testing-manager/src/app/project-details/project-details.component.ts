import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { Project } from './../../models/project';
import { ProjectService } from './../../services/project.service';
import { ExcelService } from './../../services/excel.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.scss']
})
export class ProjectDetailsComponent implements OnInit {

  @Input() project: Project;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(private projectService: ProjectService, private excelService: ExcelService) { }

  ngOnInit() {
  }

  deleteProject() {
    this.projectService.deleteProject(this.project.id).subscribe(result => {
      console.log(result);
      this.projectService.notifyProjectDeletion();
      this.closeBtn.nativeElement.click();
      this.project = null;
      alert('Project has been successfully deleted!');
    }, error => {
      console.log(error);
      alert('A problem has occured during project deletion!');
    });
  }

  exportProject() {
    if (this.project.components.length > 0) {
      this.excelService.exportProject(this.project.id).subscribe(result => {
        console.log(result);
        alert('Project has been successfully exported to D:\\ driver');
      }, error => {
        console.log(error);
        alert('An error has occured during project export!');
      });
    } else {
      alert('This project has no components yet!');
    }
  }

}
