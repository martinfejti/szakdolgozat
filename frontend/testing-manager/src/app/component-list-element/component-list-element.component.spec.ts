import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentListElementComponent } from './component-list-element.component';

describe('ComponentListElementComponent', () => {
  let component: ComponentListElementComponent;
  let fixture: ComponentFixture<ComponentListElementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ComponentListElementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ComponentListElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
