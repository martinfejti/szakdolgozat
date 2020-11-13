import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersGuideComponent } from './users-guide.component';

describe('UsersGuideComponent', () => {
  let component: UsersGuideComponent;
  let fixture: ComponentFixture<UsersGuideComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersGuideComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersGuideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
