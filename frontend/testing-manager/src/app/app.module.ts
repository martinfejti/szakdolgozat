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
import { ProjectDetailsComponent } from './project-details/project-details.component';
import { EditProjectComponent } from './edit-project/edit-project.component';
import { EditProjectService } from './edit-project/edit-project.service';
import { ComponentListElementComponent } from './component-list-element/component-list-element.component';
import { ComponentDetailsComponent } from './component-details/component-details.component';
import { AddComponentComponent } from './add-component/add-component.component';
import { EditComponentComponent } from './edit-component/edit-component.component';
import { CaseListElementComponent } from './case-list-element/case-list-element.component';
import { CaseDetailsComponent } from './case-details/case-details.component';
import { StepListElementComponent } from './step-list-element/step-list-element.component';
import { AddCaseComponent } from './add-case/add-case.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectListElementComponent,
    AddProjectComponent,
    ProjectDetailsComponent,
    EditProjectComponent,
    ComponentListElementComponent,
    ComponentDetailsComponent,
    AddComponentComponent,
    EditComponentComponent,
    CaseListElementComponent,
    CaseDetailsComponent,
    StepListElementComponent,
    AddCaseComponent
  ],
  imports: [
  HttpClientModule,
  BrowserModule,
  FormsModule,
  BrowserAnimationsModule
  ],
  providers: [
    ProjectService,
    AddProjectService,
    EditProjectService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
