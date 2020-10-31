import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentTestResultsElementComponent } from './component-test-results-element.component';

describe('ComponentTestResultsElementComponent', () => {
  let component: ComponentTestResultsElementComponent;
  let fixture: ComponentFixture<ComponentTestResultsElementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentTestResultsElementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentTestResultsElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
