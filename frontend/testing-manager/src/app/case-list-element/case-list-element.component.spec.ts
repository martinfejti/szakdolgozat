import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseListElementComponent } from './case-list-element.component';

describe('CaseListElementComponent', () => {
  let component: CaseListElementComponent;
  let fixture: ComponentFixture<CaseListElementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaseListElementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaseListElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
