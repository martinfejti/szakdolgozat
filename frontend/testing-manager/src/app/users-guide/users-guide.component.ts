import { Component, OnInit } from '@angular/core';
import { ProjectService } from './../../services/project.service';

@Component({
  selector: 'app-users-guide',
  templateUrl: './users-guide.component.html',
  styleUrls: ['./users-guide.component.scss']
})
export class UsersGuideComponent implements OnInit {

  constructor(private projetService: ProjectService) { }

  ngOnInit() {
  }

  backToMainPage() {
    this.projetService.notifySelectProject();
  }
}
