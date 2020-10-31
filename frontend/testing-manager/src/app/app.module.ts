import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { CdkStepperModule } from '@angular/cdk/stepper';
import { MatStepperModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatIconModule,
  MatProgressSpinnerModule,
  MatSidenavModule,
  MatMenuModule,
  MatListModule,
  MatDividerModule,
  MatGridListModule,
  MatExpansionModule,
  MatCardModule,
  MatTabsModule
} from '@angular/material';

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
import { EditCaseComponent } from './edit-case/edit-case.component';
import { StepDetailsComponent } from './step-details/step-details.component';
import { AddStepComponent } from './add-step/add-step.component';
import { EditStepComponent } from './edit-step/edit-step.component';
import { ComponentTestComponent } from './component-test/component-test.component';
import { CaseTestComponent } from './case-test/case-test.component';
import { StepTestComponent } from './step-test/step-test.component';
import { ComponentTestResultsComponent } from './component-test-results/component-test-results.component';
import { ComponentTestResultsElementComponent } from './component-test-results-element/component-test-results-element.component';
import { ComponentTestResultsDetailsComponent } from './component-test-results-details/component-test-results-details.component';
import { ChartsModule, ThemeService } from 'ng2-charts';

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
    AddCaseComponent,
    EditCaseComponent,
    StepDetailsComponent,
    AddStepComponent,
    EditStepComponent,
    ComponentTestComponent,
    CaseTestComponent,
    StepTestComponent,
    ComponentTestResultsComponent,
    ComponentTestResultsElementComponent,
    ComponentTestResultsDetailsComponent
  ],
  imports: [
  HttpClientModule,
  BrowserModule,
  FormsModule,
  BrowserAnimationsModule,
  DragDropModule,
  CdkStepperModule,
  MatStepperModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatIconModule,
  MatProgressSpinnerModule,
  MatSidenavModule,
  MatMenuModule,
  MatListModule,
  MatDividerModule,
  MatGridListModule,
  MatExpansionModule,
  MatCardModule,
  MatTabsModule,
  ChartsModule
  ],
  providers: [
    ProjectService,
    AddProjectService,
    EditProjectService,
    ThemeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
