import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutoSecurityMatchComponent } from './auto-security-match.component';

describe('AutoSecurityMatchComponent', () => {
  let component: AutoSecurityMatchComponent;
  let fixture: ComponentFixture<AutoSecurityMatchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutoSecurityMatchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutoSecurityMatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
