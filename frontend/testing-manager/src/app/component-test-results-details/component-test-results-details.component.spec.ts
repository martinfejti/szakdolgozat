import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentTestResultsDetailsComponent } from './component-test-results-details.component';

describe('ComponentTestResultsDetailsComponent', () => {
  let component: ComponentTestResultsDetailsComponent;
  let fixture: ComponentFixture<ComponentTestResultsDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentTestResultsDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentTestResultsDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
