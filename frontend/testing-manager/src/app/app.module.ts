import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProjectService } from './../services/project.service';
import { ProjectListElementComponent } from './project-list-element/project-list-element.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectListComponent,
    ProjectListElementComponent
  ],
  imports: [
  HttpClientModule,
  BrowserModule
  ],
  providers: [
    ProjectService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
