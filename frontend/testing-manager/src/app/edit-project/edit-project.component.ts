import { Component, OnInit, Inject, Input, ViewChild, ElementRef } from '@angular/core';
import { Project } from './../../models/project';
import { EditProjectService } from './edit-project.service';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-edit-project',
  templateUrl: './edit-project.component.html',
  styleUrls: ['./edit-project.component.scss']
})
export class EditProjectComponent implements OnInit {

  /*project: Project = {
    name: null,
    shortDescription: null,
    id: null,
    longDescription: null,
    components: null
  };*/

  @Input() project: Project;
  @ViewChild('closeBtn', {static: false}) closeBtn: ElementRef;

  constructor(@Inject(EditProjectService) private editProjectService: EditProjectService, private projectService: ProjectService) { }

  ngOnInit() {
    console.log(this.project);
  }

  editProject() {
    if (this.project.name && this.project.shortDescription) {
      this.editProjectService.editProject(this.project).subscribe(result => {
        console.log(result);
        this.closeBtn.nativeElement.click();
        this.projectService.notifyProjectEdition();
        alert('Project has been successfully edited!');
      }, error => {
        console.log(error);
        alert('A problem has occured during project edition!');
      });
    } else {
      alert('Name and short description fields are required!');
    }
  }

}
