import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StepListElementComponent } from './step-list-element.component';

describe('StepListElementComponent', () => {
  let component: StepListElementComponent;
  let fixture: ComponentFixture<StepListElementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StepListElementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StepListElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
