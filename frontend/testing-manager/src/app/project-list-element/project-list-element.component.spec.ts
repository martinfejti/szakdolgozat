import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjectListElementComponent } from './project-list-element.component';

describe('ProjectListElementComponent', () => {
  let component: ProjectListElementComponent;
  let fixture: ComponentFixture<ProjectListElementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProjectListElementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProjectListElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
