import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CaseTestComponent } from './case-test.component';

describe('CaseTestComponent', () => {
  let component: CaseTestComponent;
  let fixture: ComponentFixture<CaseTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CaseTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CaseTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
