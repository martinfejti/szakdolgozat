import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectService } from './../services/project.service';
import { AddProjectService } from './add-project/add-project.service';
import { ProjectListElementComponent } from './project-list-element/project-list-element.component';
import { AddProjectComponent } from './add-project/add-project.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectListElementComponent,
    AddProjectComponent
  ],
  imports: [
  HttpClientModule,
  BrowserModule,
  FormsModule
  ],
  providers: [
    ProjectService,
    AddProjectService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
