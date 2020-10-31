import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentTestResultsComponent } from './component-test-results.component';

describe('ComponentTestResultsComponent', () => {
  let component: ComponentTestResultsComponent;
  let fixture: ComponentFixture<ComponentTestResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentTestResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentTestResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
